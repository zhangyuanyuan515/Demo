package com.jiyun.wanandroid.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.wanandroid.R;
import com.jiyun.wanandroid.net.HttpClint;
import com.jiyun.wanandroid.project.bean.ViewPagerBean;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectTabFragment extends Fragment {


    private View view;
    private ArrayList<ViewPagerBean.DataBean.DatasBean> list;
    private MyProjectAdapter adapter;
    private String id;
    private int pager = 1;
    private XRecyclerView mXrecyclerView;

    public ProjectTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_project_tab, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        id = getArguments().getString("id");
        mXrecyclerView = (XRecyclerView) inflate.findViewById(R.id.xrecycler_project);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mXrecyclerView.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adapter = new MyProjectAdapter(getActivity(), list);
        mXrecyclerView.setAdapter(adapter);


        // 设置上拉加载和下拉刷新
        mXrecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                pager=1;
                addMore();

            }

            @Override
            public void onLoadMore() {
                addMore();
            }
        });

        addMore();
    }

    private void addMore() {
        new Thread() {
            @Override
            public void run() {
                String jsonString = HttpClint.getJsonString("https://www.wanandroid.com/project/list/" + pager++ + "/json?cid=" + id);
                ViewPagerBean viewPagerBean = new Gson().fromJson(jsonString, ViewPagerBean.class);
                List<ViewPagerBean.DataBean.DatasBean> list1 = viewPagerBean.getData().getDatas();
                list.addAll(list1);
                //主线程
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 设置下拉刷新完成
                        mXrecyclerView.refreshComplete();
                        // 设置上拉加载完成
                        mXrecyclerView.loadMoreComplete();
                        //刷新适配器
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }.start();

    }
}

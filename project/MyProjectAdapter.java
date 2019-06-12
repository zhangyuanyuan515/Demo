package com.jiyun.wanandroid.project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.wanandroid.R;
import com.jiyun.wanandroid.project.bean.ViewPagerBean;

import java.util.ArrayList;

/**
 * Created by Coffee on 2019/4/19.
 */

public class MyProjectAdapter extends RecyclerView.Adapter<MyProjectAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<ViewPagerBean.DataBean.DatasBean> list;

    public MyProjectAdapter(Context context, ArrayList<ViewPagerBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_project_fragment, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ViewPagerBean.DataBean.DatasBean datasBean = list.get(position);

        Glide.with(context).load(datasBean.getEnvelopePic()).into(holder.iv);
        holder.tv_title.setText(datasBean.getTitle());
        holder.tv_desc.setText(datasBean.getDesc());
        holder.tv_author.setText(datasBean.getAuthor());
        holder.tv_niceDate.setText(datasBean.getNiceDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv_title,tv_desc,tv_author,tv_niceDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_niceDate = itemView.findViewById(R.id.tv_niceDate);

        }
    }
}

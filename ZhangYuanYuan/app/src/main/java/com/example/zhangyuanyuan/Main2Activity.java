package com.example.zhangyuanyuan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.zhangyuanyuan.adapter.RecviewAdapter;
import com.example.zhangyuanyuan.bean.Bean;
import com.example.zhangyuanyuan.model.Mymodelim;
import com.example.zhangyuanyuan.presneter.Mypresneterrr;
import com.example.zhangyuanyuan.view.Myview;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements Myview {

    private static final String TAG = Main2Activity.class.getName();
    private RecyclerView mRe;
    private Toolbar mToolbar;
    private Mypresneterrr mypresneterrr;
    private ArrayList<Bean.ResultBean> list=new ArrayList<>();
    private RecviewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initdata();
    }

    private void initdata() {
        mypresneterrr = new Mypresneterrr(new Mymodelim(), this);
        mypresneterrr.getdata();
    }

    private void initView() {
        mRe = (RecyclerView) findViewById(R.id.re);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRe.setLayoutManager(new LinearLayoutManager(this));
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);

        adapter = new RecviewAdapter(this, list);
        mRe.setAdapter(adapter);

        adapter.setClick(new RecviewAdapter.onclick() {
            @Override
            public void onclick(View view, int i) {
                String thumbnail = list.get(i).getThumbnail();
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                intent.putExtra("thumbnail",thumbnail);
                startActivity(intent);
            }
        });

    }

    @Override
    public void getSuccess(Bean bean) {
        ArrayList<Bean.ResultBean> result = bean.getResult();
        list.addAll(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getOnfaile(String msg) {
        Log.e(TAG, "getOnfaile: "+msg );
    }
}

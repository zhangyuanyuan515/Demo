package com.example.zhangyuanyuan;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.zhangyuanyuan.bean.Bean;
import com.example.zhangyuanyuan.model.Mymodelim;
import com.example.zhangyuanyuan.presneter.Mypresneterrr;
import com.example.zhangyuanyuan.view.Myview;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements Myview {

    private static final String TAG = Main3Activity.class.getName();
    private ViewPager mVp;
    private Mypresneterrr mypresneterrr;
    private ArrayList<Bean.ResultBean> list = new ArrayList<>();
    private Toolbar mToolbar;
    private PagerAdapter pagerAdapter;
    private com.example.zhangyuanyuan.adapter.PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initdata();
    }

    private void initdata() {
        mypresneterrr = new Mypresneterrr(new Mymodelim(), this);
        mypresneterrr.getdata();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        adapter = new com.example.zhangyuanyuan.adapter.PagerAdapter(this, list);
        mVp.setAdapter(adapter);
    }

    @Override
    public void getSuccess(Bean bean) {
        ArrayList<Bean.ResultBean> result = bean.getResult();
        getIntent().getSerializableExtra("thumbnail")
        list.addAll(result);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getOnfaile(String msg) {
        Log.e(TAG, "getOnfaile: "+msg );

    }
}

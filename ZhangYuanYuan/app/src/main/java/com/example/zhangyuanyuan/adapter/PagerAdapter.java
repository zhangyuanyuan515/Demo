package com.example.zhangyuanyuan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhangyuanyuan.R;
import com.example.zhangyuanyuan.bean.Bean;

import java.util.ArrayList;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    private Context context;
    private ArrayList<Bean.ResultBean> list;

    public PagerAdapter(Context context, ArrayList<Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.pager_item, container, false);
        ImageView im = inflate.findViewById(R.id.pager_im);
        TextView tv1 = inflate.findViewById(R.id.pager_tv1);
        TextView weizhi = inflate.findViewById(R.id.weizhi);
        Glide.with(context).load(list.get(position).getThumbnail()).into(im);
        tv1.setText(list.get(position).getName());
        weizhi.setText(position-1+"");
        container.addView(inflate);

        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}

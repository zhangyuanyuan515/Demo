package com.jiyun.wanandroid.project;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jiyun.wanandroid.project.bean.ProjectTabBaean;

import java.util.ArrayList;

/**
 * Created by Coffee on 2019/4/19.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ProjectTabFragment> lists;
    private ArrayList<ProjectTabBaean.DataBean> mlist;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<ProjectTabFragment> lists, ArrayList<ProjectTabBaean.DataBean> mlist) {
        super(fm);
        this.lists = lists;
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return lists.get(position);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mlist.get(position).getName();
    }
}

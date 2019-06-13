package com.example.zhangyuanyuan.api;

import com.example.zhangyuanyuan.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myservise {
    public String url="http://api.apiopen.top/";
    @GET("getJoke")
    Observable<Bean> geturl();
}

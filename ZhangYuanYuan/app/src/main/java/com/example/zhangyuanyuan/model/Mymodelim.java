package com.example.zhangyuanyuan.model;

import android.util.Log;

import com.example.zhangyuanyuan.api.Myservise;
import com.example.zhangyuanyuan.bean.Bean;
import com.example.zhangyuanyuan.callback.CallBackk;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

public class Mymodelim implements Mymodel{
    @Override
    public void getdata(final CallBackk callBackk) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Myservise.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Myservise myservise = retrofit.create(Myservise.class);
        Observable<Bean> geturl = myservise.geturl();
        geturl.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        callBackk.getSuccess(bean);
                        Log.e(TAG, "onNext: "+bean );

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBackk.getOnfaile(e.getMessage());
                        Log.e(TAG, "onError: "+e.getMessage() );

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

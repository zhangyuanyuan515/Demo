package com.example.zhangyuanyuan.presneter;

import com.example.zhangyuanyuan.bean.Bean;
import com.example.zhangyuanyuan.callback.CallBackk;
import com.example.zhangyuanyuan.model.Mymodel;
import com.example.zhangyuanyuan.view.Myview;

public class Mypresneterrr implements Mypresneter, CallBackk {
    private Mymodel mymodel;
    private Myview myview;

    public Mypresneterrr(Mymodel mymodel, Myview myview) {
        this.mymodel = mymodel;
        this.myview = myview;
    }

    @Override
    public void getdata() {
        mymodel.getdata(this);

    }

    @Override
    public void getSuccess(Bean bean) {
        myview.getSuccess(bean);
    }

    @Override
    public void getOnfaile(String msg) {
        myview.getOnfaile(msg);

    }
}

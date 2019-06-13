package com.example.zhangyuanyuan;
//张媛媛  1809A

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
               if (count==1){
                   Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                   startActivity(intent);
                   timer.cancel();
                   finish();
               }
            }
        }
    };

    /**
     * 欢迎来到北京积云教育
     */
    private TextView mTv;
    private int count=3;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                count--;
                handler.sendEmptyMessage(1);
            }
        },500,1000);
    }
}

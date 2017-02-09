package com.example.zm.text3.ui;

import android.os.Bundle;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.view.MyBanner1;

public class Activity14 extends BaseActivity {
    private MyBanner1 banner;
    private String[] img=new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_14);
        initToolBar(getIntent().getStringExtra("string"), true);
        banner= (MyBanner1) findViewById(R.id.banner);
            img[0]="http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s780iy3sj20g40arwgt.jpg";
            img[1]="http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s783pdvrj20g40ardi2.jpg";
            img[2]="http://ww2.sinaimg.cn/mw690/b2b1bff9jw1f8s786bhw6j20go0b4wga.jpg";
            img[3]="http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s780iy3sj20g40arwgt.jpg";
//            img[4]="http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s780iy3sj20g40arwgt.jpg";
        banner.initData(img);
    }
}

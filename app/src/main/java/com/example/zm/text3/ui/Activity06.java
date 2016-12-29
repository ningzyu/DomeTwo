package com.example.zm.text3.ui;

import android.os.Bundle;
import android.widget.ListView;

import com.example.zm.text3.R;
import com.example.zm.text3.adapters.Adapter06;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.entity.Entity_6;

import java.util.ArrayList;
import java.util.List;

public class Activity06 extends BaseActivity {
    private ListView lv;
    private List<Entity_6> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_06);
        initToolBar(getIntent().getStringExtra("string"), true);
        initView();
        initData();
        Adapter06 ada=new Adapter06(this,list,R.layout.lv6_item);
        lv.setAdapter(ada);
    }

    private void initData() {
        for (int i=0;i<25;i++){
            Entity_6 e6=new Entity_6();
            e6.setTitle("第"+i+"件商品");
            e6.setPrice(i*1.25);
            e6.setPitch(false);
            list.add(e6);
        }
    }

    private void initView() {
        lv= (ListView) findViewById(R.id.lv_v6);
    }
}

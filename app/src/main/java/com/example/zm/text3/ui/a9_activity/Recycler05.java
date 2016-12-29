package com.example.zm.text3.ui.a9_activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a9_activity.recycler_adapter.Adapter_R5;
import com.example.zm.text3.ui.a9_activity.entity.R5_Entity;
import com.example.zm.text3.ui.a9_activity.entity.URLs;

import java.util.List;

public class Recycler05 extends BaseActivity{
    private List<R5_Entity.ListBean> list;
    private Adapter_R5 adapter;

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler05);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_r5);
        Gsons();
    }
    private void Gsons() {
        R5_Entity heng= JSON.parseObject(URLs.path,R5_Entity.class);
        list=heng.getList();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        adapter = new Adapter_R5(this,list, mRecyclerView);
        Log.i("Aaaaaaaaaaaaa",list.size()+"");
        mRecyclerView.setAdapter(adapter);    }
}

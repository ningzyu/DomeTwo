package com.example.zm.text3.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a9_activity.Recycler01;
import com.example.zm.text3.ui.a9_activity.Recycler02;
import com.example.zm.text3.ui.a9_activity.Recycler03;
import com.example.zm.text3.ui.a9_activity.Recycler04;
import com.example.zm.text3.ui.a9_activity.Recycler05;
import com.example.zm.text3.ui.a9_activity.Recycler06;

import java.util.ArrayList;
import java.util.List;

public class Activity09 extends BaseActivity {
    private ListView lv;
    List<String> list_s=new ArrayList<>();
    List<Activity> list_a=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_09);
        initToolBar(getIntent().getStringExtra("string"), true);
        ddd();
        lv= (ListView) findViewById(R.id.lv_v9);
        Activity09.myAdapter ada=new Activity09.myAdapter();
        lv.setAdapter(ada);
    }

    private void ddd() {
        initData("基础使用",new Recycler01());
        initData("Type改变视图",new Recycler02());
        initData("瀑布流",new Recycler03());
        initData("拖动效果",new Recycler04());
        initData("横竖滑动",new Recycler05());
        initData("横屏分页",new Recycler06());
    }

    private void initData(String s,Activity a) {
        list_a.add(a);
        list_s.add(s);
    }
    class myAdapter extends BaseAdapter {
        private LayoutInflater inflater;//布局填充器
        public myAdapter(){
            inflater=(LayoutInflater)Activity09.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return list_s.size();
        }

        @Override
        public Object getItem(int i) {
            return list_s.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            if(view==null){//
                view=inflater.inflate(R.layout.lv_item,null);
            }
            Button bt= (Button) view.findViewById(R.id.btn);
            bt.setText(list_s.get(i));
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Activity09.this,list_a.get(i).getClass()).putExtra("string",list_s.get(i)));
                }
            });
            return view;
        }
    }
}
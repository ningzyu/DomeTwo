package com.example.zm.text3.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.adapters.Adapter02;
import com.example.zm.text3.base.BaseActivity;

import java.util.ArrayList;

public class Activity02 extends BaseActivity {
    private ListView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);
        initView();
        //模拟给适配器添加数据
        ArrayList<String> strings = new ArrayList();
        for (int i = 0; i < 30; i++) {
            strings.add("Item-->0" + i);
        }
        //给listview添加第一个头部
        View view = View.inflate(this, R.layout.headview, null);
        mLv.addHeaderView(view);
        mLv.addFooterView(view);
        initToolBar(getIntent().getStringExtra("string"), true);
//        //添加一个显示的悬停部分
//        TextView tv = new TextView(this);
//        tv.setText("悬停部分");
//        tv.setTextSize(22);
//        mLv.addHeaderView(tv);
        //设置适配器
        Adapter02 adapter = new Adapter02(this);
        adapter.setStrings(strings);
        mLv.setAdapter(adapter);
        //设置listview的滑动监听
        mLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                //当滑动到第一个是，将悬停部分设置为显示
                if (firstVisibleItem >= 1) {
                    mToolbar.setVisibility(View.VISIBLE);
                } else {
                    mToolbar.setVisibility(View.GONE);
                }
            }
        });
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity02.this, "点击了悬停部分", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
//        mTv = (TextView) findViewById(R.id.tv);
    }
}
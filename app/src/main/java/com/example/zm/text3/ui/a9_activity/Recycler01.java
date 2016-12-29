package com.example.zm.text3.ui.a9_activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a9_activity.recycler_adapter.Adapter_R1;

import java.util.ArrayList;
import java.util.List;

public class Recycler01 extends BaseActivity {
    private RecyclerView rv;
    private Adapter_R1 ada;
    private List<String> data;
    private int flag=0;// 0:listview 1:gridview
    public static final String URL_PATH="http://dxy.com/app/i/feed/index/list?hardName=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&u=&bv=2015&ac=d5424fa6-adff-4b0a-8917-4264daf4a348&vc=5.1.9&vs=5.1&mc=00000000600ba4e6ffffffff99d603a9";
    private StaggeredGridLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler01);
        initToolBar(getIntent().getStringExtra("string"), true);
        data();
        initView();

        manager=new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        ada=new Adapter_R1(data);
        rv.setAdapter(ada);
        click();
    }

    private void data() {
        data = new ArrayList<>();


        for (int i = 'A'; i < 'Z'; i++) {
            data.add("" + (char) i);
        }
    }

    private void initView() {
        rv= (RecyclerView) findViewById(R.id.vip_recycler1);
        //设置布局管理器
        //1、第一种LinearLayoutManager现行管理器，支持横向、纵向
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//默认横向
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //2、第二种 GridLayoutManager网格布局管理器
//        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        //设置布局的排版方向
//        layoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        //3、第三种瀑布就式布局管理器(HORIZONTAL.横向，VERTICAL,纵向)

    }
    public void click(){
        TextView click= (TextView)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0){
                    manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                    rv.setLayoutManager(manager);
                    flag=1;
                }else if(flag==1){
                    manager=new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
                    rv.setLayoutManager(manager);
                    flag=0;
                }
            }
        });

    }


}



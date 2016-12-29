package com.example.zm.text3.ui.a9_activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a9_activity.entity.R2_Entity;
import com.example.zm.text3.ui.a9_activity.recycler_adapter.Adapter_R2;

import java.util.ArrayList;
import java.util.List;

public class Recycler02 extends BaseActivity  implements Adapter_R2.OnItemClickLietener{
    private RecyclerView mRecyclerView;
    private Adapter_R2 adapter;
    private List<R2_Entity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler02);
        initToolBar(getIntent().getStringExtra("string"), true);
        initData();
        init();

    }


    private void init() {
        mRecyclerView = (RecyclerView)findViewById(R.id.order_recycler1);
        //设置布局管理器.spanCount即列数。这里GridLayoutManager的第二个参数就是spanCount。
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);
        //span size表示一个item的跨度，跨度了多少个span。
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int spansize=1;
                switch (adapter.getItemViewType(position)) {
                    case 1:
                        spansize=6;
                        break;
                    case 2:
                        spansize=2;
                        break;
                    case 3:
                        spansize=3;
                        break;
                }
                return spansize;
            }
        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new Adapter_R2(this, list);
        mRecyclerView.setAdapter(adapter);
        adapter.setClickLietener(this);
    }
    //点击事件
    @Override
    public void setItemClickListener(int position) {
        Toast.makeText(this,list.get(position).getType()+"----"+position,Toast.LENGTH_SHORT).show();
    }



    //数据源
    private void initData() {
        list=new ArrayList<>();
        for (int i=0;i<2;i++){
            R2_Entity o=new R2_Entity();
            o.setType(1);
            o.setImg("http://pic16.nipic.com/20110921/7247268_215811562102_2.jpg");
            list.add(o);
        }
        for (int i=0;i<18;i++){
            R2_Entity o=new R2_Entity();
            o.setType(2);
            o.setImg("http://pica.nipic.com/2007-10-09/200710994020530_2.jpg");
            list.add(o);
        }
        for (int i=0;i<10;i++){
            R2_Entity o=new R2_Entity();
            o.setType(3);
            o.setImg("http://pic16.nipic.com/20110921/7247268_215811562102_2.jpg");
            list.add(o);
        }
    }
}


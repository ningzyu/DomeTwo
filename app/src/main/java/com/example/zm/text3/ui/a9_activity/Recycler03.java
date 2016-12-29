package com.example.zm.text3.ui.a9_activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a9_activity.entity.R2_Entity;
import com.example.zm.text3.ui.a9_activity.recycler_adapter.Adapter_R3;

import java.util.ArrayList;
import java.util.List;

public class Recycler03 extends BaseActivity implements Adapter_R3.OnItemClickLietener{
    private RecyclerView recycler_r3;
    private Adapter_R3 adapter;
    private List<R2_Entity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler03);
        initToolBar(getIntent().getStringExtra("string"), true);
        recycler_r3= (RecyclerView) findViewById(R.id.recycler_r3);
        //设置layoutManager
        recycler_r3.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initData();
        adapter=new Adapter_R3(this,list);
        recycler_r3.setAdapter(adapter);
        adapter.setClickLietener(this);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recycler_r3.addItemDecoration(decoration);

    }

    //数据源
    private void initData() {
        list=new ArrayList<>();
        int [] img={R.drawable.b,R.drawable.a,R.drawable.c,R.drawable.a,R.drawable.c,R.drawable.c,R.drawable.b,
                R.drawable.a,R.drawable.c,R.drawable.b,R.drawable.a,R.drawable.c,R.drawable.a,R.drawable.c,R.drawable.c,R.drawable.b,
                R.drawable.a,R.drawable.c};
        for (int i=0;i<img.length;i++){
            R2_Entity o=new R2_Entity();
            o.setType(img[i]);
            o.setImg("图"+i);
            list.add(o);
        }
    }

    @Override
    public void setItemClickListener(int position) {
        Toast.makeText(this,list.get(position).getImg(),Toast.LENGTH_SHORT).show();
    }


    class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;
        public SpacesItemDecoration(int space) {
            this.space=space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }
}

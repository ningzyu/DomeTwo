package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zm.text3.R;

import java.util.List;

/**
 * Created by zm on 2016/12/6.
 */

public class Adapter_R1  extends RecyclerView.Adapter<Adapter_R1.MyViewHolder> {
    private List<String> list;
    public Adapter_R1(List<String> list){
        this.list=list;
    }
    //开启初始化控件内部类
    @Override
    public Adapter_R1.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Adapter_R1.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.r1_item, parent, false));

    }
    //控件赋值及事件处理
    @Override
    public void onBindViewHolder(Adapter_R1.MyViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.title.setText(list.get(position));
    }
    //返回集合长度（item总数）
    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_item1);
        }
    }
}

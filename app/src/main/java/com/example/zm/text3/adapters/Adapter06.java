package com.example.zm.text3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zm.text3.R;
import com.example.zm.text3.entity.Entity_6;

import java.util.List;

/**
 * Created by zm on 2016/12/3.
 */

public class Adapter06 extends BaseAdapter {
    private List<Entity_6> list;
    private int resource;//自定义样式
    private LayoutInflater inflater;//布局填充器
    public Adapter06(Context context,List<Entity_6> list,int resource){
        this.list=list;
        this.resource=resource;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    //获取集合大小
    public int getCount() {
        return list.size();
    }

    @Override
    //获取集合中某一个值，即列表项，listview中一行数据
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    //获取列表项的索引值
    public long getItemId(int position) {
        return position;
    }

    @Override
    //
    //1索引 2容器 3
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=inflater.inflate(resource,null);
            vh.rg= (RadioGroup) convertView.findViewById(R.id.rg);
            vh.pitch= (RadioButton) convertView.findViewById(R.id.rg_btn);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();
        }
        final Entity_6 e6=list.get(position);
        vh.pitch.setText(e6.getTitle());
//        vh.pitch.setChecked(e6.isPitch());//为按钮赋状态
        vh.pitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vh.pitch.isChecked()){
                    vh.pitch.setChecked(true);
                }else {
                    vh.pitch.setChecked(false);
                }
            }
        });
//        //单选按钮监听
//        vh.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                e6.setPitch(vh.pitch.isChecked());
//            }
//        });
        return convertView;
    }
    //內部类优化--定义属性
    class ViewHolder{
        RadioGroup rg;//定义单选按钮组
        RadioButton pitch;
    }
}

package com.example.zm.text3.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.entity.Entity_8;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by zm on 2016/12/5.
 */

public class Adapter08  extends BaseAdapter {
    private List<Entity_8.ResultBean.ListBean> list;
    private int resource;//自定义样式
    private LayoutInflater inflater;//布局填充器
    private Context context;
    public Adapter08(Context context, List<Entity_8.ResultBean.ListBean> list, int resource){
        this.context=context;
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
            vh.tv= (TextView) convertView.findViewById(R.id.tv_v8);
            vh.iv= (ImageView) convertView.findViewById(R.id.iv_v8);
            convertView.setTag(vh);
        }else{
            vh=(ViewHolder)convertView.getTag();
        }
        final Entity_8.ResultBean.ListBean e8=list.get(position);
        vh.tv.setText(e8.getTitle());
        getImg(context,e8.getFirstImg(),vh.iv);
        return convertView;
    }
    //內部类优化--定义属性
    class ViewHolder{
        TextView tv;
        ImageView iv;
    }

    public static void getImg(Context context,String path,final ImageView iv){
        Picasso picasso= Picasso.with(context);
        picasso.load(path).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .config(Bitmap.Config.RGB_565)
                .into(iv);
    }
}

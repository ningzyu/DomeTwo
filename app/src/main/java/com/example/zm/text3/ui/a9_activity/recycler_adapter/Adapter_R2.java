package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.toos.Toos;
import com.example.zm.text3.ui.a9_activity.entity.R2_Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zm on 2016/12/6.
 */

public class Adapter_R2  extends RecyclerView.Adapter<Adapter_R2.ViewHolder> implements View.OnClickListener{
    private List<R2_Entity> list;
    private LayoutInflater inflater;//布局填充器
    private RecyclerView mRecyclerView;

    private Context context;
    private Adapter_R2.OnItemClickLietener clickLietener;//点击事件接口
    public void setClickLietener(Adapter_R2.OnItemClickLietener clickLietener){
        this.clickLietener=clickLietener;
    }

    public Adapter_R2(Context context, List<R2_Entity> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public Adapter_R2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 1:
                itemView = inflater.inflate(R.layout.r2_item, parent, false);
                break;
            case 2:
                itemView = inflater.inflate(R.layout.r2_item, parent, false);
                break;
            case 3:
                itemView = inflater.inflate(R.layout.r2_item, parent, false);
                break;
            //设置监听
        }
        itemView.setOnClickListener(this);
        return new Adapter_R2.ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(Adapter_R2.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 1:
                ImageView img1 = (ImageView) holder.getView(R.id.iv_r2);
                String picPath1 = list.get(position).getImg();
                Toos.getImg(context,picPath1,img1);
                break;
            case 2:
                ImageView img2 = (ImageView) holder.getView(R.id.iv_r2);
                String picPath2 = list.get(position).getImg();
                Toos.getImg(context,picPath2,img2);
                break;
            case 3:
                ImageView img3 = (ImageView) holder.getView(R.id.iv_r2);
                String picPath3 = list.get(position).getImg();
                Toos.getImg(context,picPath3,img3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        if (clickLietener!=null) {
            clickLietener.setItemClickListener(childAdapterPosition);
        }
    }
    //ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Map<Integer, View> map;

        public ViewHolder(View itemView) {
            super(itemView);
            map = new HashMap<>();
        }

        public View getView(int resId) {
            View view;
            if (map.containsKey(resId)) {
                view = map.get(resId);
            } else {
                view = itemView.findViewById(resId);
                map.put(resId, view);
            }
            return view;
        }
    }
    //点击事件接口
    public interface OnItemClickLietener{
        void setItemClickListener(int position);
    }

}

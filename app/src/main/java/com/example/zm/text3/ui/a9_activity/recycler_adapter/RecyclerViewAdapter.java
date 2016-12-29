package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.ui.a9_activity.helper.onMoveAndSwipedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zm on 2016/12/7.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>
        implements onMoveAndSwipedListener {
    private final List<String> mItems = new ArrayList<>();

    public RecyclerViewAdapter(Context context){
        //初始化数据
        mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
    }

    /**在这里反射出我们的item的布局*/
    @Override
    public RecyclerViewAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //利用反射将item的布局加载出来
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.r4_item,null);
        //new一个我们的ViewHolder，findViewById操作都在ItemViewHolder的构造方法中进行了
        return new ItemViewHolder(view);
    }
    /**在这里为布局中的控件设置数据*/
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.text.setText(mItems.get(position));
        //handle是我们拖动item时候要用的，目前先空着
        holder.handle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
    /**返回数据个数*/
    @Override
    public int getItemCount() {
        return mItems.size();
    }



    /**相当于ListView中的ViewHolder*/
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private ImageView handle;
        public ItemViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            handle = (ImageView) itemView.findViewById(R.id.handle);
        }
    }
    /**
     *我们让RecyclerViewAdapter实现onMoveAndSwipedListener接口，并且重写里面的两个方法
     */
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //交换mItems数据的位置
        Collections.swap(mItems,fromPosition,toPosition);
        //交换RecyclerView列表中item的位置
        notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        //删除mItems数据
        mItems.remove(position);
        //删除RecyclerView列表对应item
        notifyItemRemoved(position);
    }

}
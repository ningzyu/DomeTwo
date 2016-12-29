package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.ui.a9_activity.entity.R2_Entity;

import java.util.List;

/**
 * Created by zm on 2016/12/6.
 */

public class Adapter_R3  extends RecyclerView.Adapter<Adapter_R3.MasonryView> implements View.OnClickListener{
    private List<R2_Entity> products;
    private RecyclerView mRecyclerView;
    private Context context;

    private Adapter_R3.OnItemClickLietener clickLietener;//点击事件接口
    public void setClickLietener(Adapter_R3.OnItemClickLietener clickLietener){
        this.clickLietener=clickLietener;
    }

    public Adapter_R3(Context context,List<R2_Entity> list) {
        this.context=context;
        products=list;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.r3_item, viewGroup, false);
        view.setOnClickListener(this);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
//        Toos.getImg(context,products.get(position).getImg(),masonryView.imageView);
        masonryView.imageView.setImageResource(products.get(position).getType());
        masonryView.textView.setText(products.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public void onClick(View view) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(view);
        if (clickLietener!=null) {
            clickLietener.setItemClickListener(childAdapterPosition);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView=recyclerView;
    }

    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }
    //点击事件接口
    public interface OnItemClickLietener{
        void setItemClickListener(int position);
    }
}
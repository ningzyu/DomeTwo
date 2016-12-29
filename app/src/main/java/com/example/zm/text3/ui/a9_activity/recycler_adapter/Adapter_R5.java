package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.toos.Toos;
import com.example.zm.text3.ui.a9_activity.view.MyRecyclerView;
import com.example.zm.text3.ui.a9_activity.entity.R5_Entity;
import com.example.zm.text3.view.MyBanner;

import java.util.List;

/**
 * Created by zm on 2016/12/13.
 */

public class Adapter_R5 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private RecyclerView recyclerView;
    private List<R5_Entity.ListBean> list;
    //刷新页面是调用
    public List<R5_Entity.ListBean> getResults() {
        return list;
    }
    //type
    public static final int TYPE_1 = 0xff01;//轮播
    public static final int TYPE_2 = 0xff02;//列表
    public static final int TYPE_3 = 0xff03;//横滑

    public Adapter_R5(Context context, List<R5_Entity.ListBean> listItem, RecyclerView recyclerView) {
        this.mContext = context;
        this.recyclerView = recyclerView;
        this.list = listItem;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (Integer.parseInt(list.get(position).getType())== 1)
            return TYPE_1;//轮播
        else if (Integer.parseInt(list.get(position).getType())== 2)
            return TYPE_2;//列表
//        else if (Integer.parseInt(list.get(position).getType())== 3)
        else
            return TYPE_3;//横滑

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_1:
                return new Adapter_R5.ViewHolder01(mLayoutInflater.inflate(R.layout.item_banner, parent, false));
            case TYPE_2:
                View hold2 = mLayoutInflater.inflate(R.layout.item_text, parent, false);
                return new Adapter_R5.ViewHolder03(hold2);
            case TYPE_3:
                View hold = mLayoutInflater.inflate(R.layout.item_image, parent, false);
                return new Adapter_R5.ViewHolder02(hold);
//            case TYPE_MAIN:
//                return new MyViewHolderMain(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_typemain, parent, false));
            default:
                Log.d("error","viewholder is null");
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder01){
            bindType1((ViewHolder01) holder, position);
        }else if (holder instanceof ViewHolder02){
            bindType2((ViewHolder02) holder, position);
        }else if (holder instanceof ViewHolder03){
            bindType3((ViewHolder03) holder, position);
        }
    }
    private void bindType1(ViewHolder01 holder, int position){
//        String[] imgs = new String[list.get(position).getLunbo().size()];
//        for (int i=0;i<list.get(position).getLunbo().size();i++){
//            imgs [i]=list.get(position).getLunbo().get(i).getBaner();
//        }
//        holder.slideShowView.initData(imgs);
    }
    private void bindType2(ViewHolder02 holder, int position){
        holder.mTextView.setText(list.get(position).getTitle());
        MyRecyclerView hold = holder.mRecyclerView;
        if (hold.getAdapter() != null && hold.getAdapter() instanceof HorizontAdapter) {
            //单纯设置数据
            getPhotosetImageJsonURl((HorizontAdapter) hold.getAdapter(), position);
        } else {
            //设置水平适配器
            hold.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            HorizontAdapter horizontalAdapter = new HorizontAdapter(mContext, null, hold);
            hold.setAdapter(horizontalAdapter);
            getPhotosetImageJsonURl(horizontalAdapter, position);
        }
    }
    private void bindType3(ViewHolder03 holder, int position){
        if (list.size() - 1 >= position) {
            holder.mTitle.setText(list.get(position).getTitle());
            Log.i("aaaaaaaaaaaaaaaaa",list.get(position).getPic_url());
            Toos.getImg(mContext,list.get(position).getPic_url(), holder.mImageView);
//            holder.v.setOnClickListener(new Adapter_R5.TextViewHolderListener(position));
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    //轮播广告ViewHold
    public static class ViewHolder01 extends RecyclerView.ViewHolder {
        public MyBanner slideShowView;
        public ViewHolder01(View itemView) {
            super(itemView);
            slideShowView = (MyBanner) itemView.findViewById(R.id.slideShowView);
        }
    }
    //横滑模块ViewHolder
    public static class ViewHolder02 extends RecyclerView.ViewHolder {
        TextView mTextView;
        MyRecyclerView mRecyclerView;
        ViewHolder02(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_title);

            mRecyclerView = (MyRecyclerView) view.findViewById(R.id.rv_subrecycleview);
        }
    }
    //竖滑模块ViewHolder
    public static class ViewHolder03 extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitle;
        View v;
        ViewHolder03(View view) {
            super(view);
            v = view;
            mImageView = (ImageView) view.findViewById(R.id.iv_left_image);
            mTitle = (TextView) view.findViewById(R.id.list_item_news_title);
        }
    }


    //竖滑点击事件
    class TextViewHolderListener implements View.OnClickListener {
        int position;
        TextViewHolderListener(int i) {
            position = i;
        }
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,"第"+position+"件商品",Toast.LENGTH_SHORT).show();
        }
    }
    //横滑点击事件
    class ImageViewHolderListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(mContext,"第x件商品",Toast.LENGTH_SHORT).show();
        }
    }
    //获取横滑图片链接并展示
    private void getPhotosetImageJsonURl(final HorizontAdapter adapter, int position) {
        adapter.setPhotoSet(list.get(position).getHeng());
        adapter.notifyDataSetChanged();
    }
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
//        if(manager instanceof GridLayoutManager) {
//            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
//            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                @Override
//                public int getSpanSize(int position) {
//                    int type = getItemViewType(position);
//                    switch (type){
//                        case TYPE_1:
//                        case TYPE_2:
//                        case TYPE_3:
//                        case TYPE_4:
//                            return gridManager.getSpanCount();
//                        default:
//                            return 1;
//                    }
//                }
//            });
//        }
//    }

}

package com.example.zm.text3.ui.a9_activity.recycler_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.zm.text3.R;
import com.example.zm.text3.toos.Toos;
import com.example.zm.text3.ui.a9_activity.entity.R5_Entity;

import java.util.List;

/**
 * 水平RecyclerView适配器
 */
public class HorizontAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private RecyclerView recyclerView;
    List<R5_Entity.ListBean.HengBean> photoSet ;
    int imageWeight;
    int imageHeight;


    public HorizontAdapter(Context context, List<R5_Entity.ListBean.HengBean>  photoSet, RecyclerView recyclerView) {
        mContext = context;
        this.recyclerView = recyclerView;
        mLayoutInflater = LayoutInflater.from(context);
        this.photoSet = photoSet;


        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        imageHeight = width/3;//边距
        imageWeight =  width/3;
    }

    public void setPhotoSet(List<R5_Entity.ListBean.HengBean> photoSet) {
        this.photoSet = photoSet;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 0 : position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View hold = mLayoutInflater.inflate(R.layout.item_sub_image, parent, false);
        return new ImageViewHolder(hold, imageWeight, imageHeight, recyclerView, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (photoSet == null) {
            Toos.getImg(mContext,"",((ImageViewHolder) holder).imageView);
        } else {
            Toos.getImg(mContext, photoSet.get(position).getPic_url(),((ImageViewHolder) holder).imageView);
        }
    }

    @Override
    public int getItemCount() {
        return photoSet.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        IMyViewHolderClicks mListener;
        int index;
        boolean isMoved = false;
        ImageViewHolder(View view , int weight, int height, RecyclerView recyclerView, int i) {
            super(view);
            index = i;
            isMoved = false;
            //第一张图不要边距
            if (index == 0) {
                RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                RelativeLayout rv = (RelativeLayout) view.findViewById(R.id.rlContainer);
                rl.setMargins(0, 0, 0, 0);
                rv.setLayoutParams(rl);
            }
            imageView = (ImageView) view.findViewById(R.id.iv_sub_image);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(weight, height));
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP && !isMoved)
                        mListener.onViewPageTouch((ImageView) v, index);
                    else {
                        isMoved = false;
                    }
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        isMoved = true;
                    }
                    return true;
                }
            });
        }

        public interface IMyViewHolderClicks {
            void onViewPageTouch(ImageView callerImage, int index);
        }
    }

}

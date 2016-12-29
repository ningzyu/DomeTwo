package com.example.zm.text3.ui.a9_activity.helper;
/**
 * 当item被拖拽或者侧滑的时候会回调onMove和onSwiped方法，
 * 所以我们需要同时Adapter做出相应的改变，
 * 对mItems数据做出交换或者删除的操作，
 * 因此我们需要一个回调接口来继续回调Adapter中的方法
 */
public interface onMoveAndSwipedListener {

    boolean onItemMove(int fromPosition , int toPosition);
    void onItemDismiss(int position);
    /**
     *我们让RecyclerViewAdapter实现onMoveAndSwipedListener接口，并且重写里面的两个方法
     */
}


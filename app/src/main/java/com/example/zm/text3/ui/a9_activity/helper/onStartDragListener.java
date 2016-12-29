package com.example.zm.text3.ui.a9_activity.helper;

import android.support.v7.widget.RecyclerView;

/**
 * 为实现点击图片即可拖动效果
 * 在ImageView的onTouch方法中，我们应该回调RecyclerListFragment类中的mItemTouchHelper，
 * 调用mItemTouchHelper的onStartDrag方法，因此我们又需要一个回调接口
 */

public interface onStartDragListener {
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}

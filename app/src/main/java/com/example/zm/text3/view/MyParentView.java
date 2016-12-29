package com.example.zm.text3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by zm on 2016/12/6.
 */

public class MyParentView extends LinearLayout {

    private int mMove;
    private int yDown, yMove;
    private int i = 0;
    public MyParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN://获取刚开始触碰的y坐标
                yDown = y;
                break;
            //如果是向下滑动，计算出每次滑动的距离与滑动的总距离，将每次滑动的距离作为layout(int l, int t, int r, int b)方法的参数，重新进行布局，达到布局滑动的效果。
            case MotionEvent.ACTION_MOVE:
                yMove = y;
                if ((yMove - yDown) > 0) {
                    mMove = yMove - yDown;
                    i += mMove;
                    layout(getLeft(), getTop() + mMove, getRight(), getBottom() + mMove);
                }
                break;
            //将滑动的总距离作为layout(int l, int t, int r, int b)方法的参数，重新进行布局，达到布局自动回弹的效果。
            case MotionEvent.ACTION_UP:
                layout(getLeft(), getTop() - i, getRight(), getBottom() - i);
                i = 0;
                break;
        }
        return true;
    }
}

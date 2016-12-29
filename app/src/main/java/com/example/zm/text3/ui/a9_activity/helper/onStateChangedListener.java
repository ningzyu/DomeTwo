package com.example.zm.text3.ui.a9_activity.helper;

/**
 * 改变item的背景颜色我们仍然需要在adapter中去做实际的修改，
 * 因此我们还需要一个回调接口，我们已经写了3个回调接口了
 */

public interface onStateChangedListener {
    void onItemSelected();
}

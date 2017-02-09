package com.example.zm.text3.ui.a9_activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zm.text3.ui.a9_activity.helper.SimpleItemTouchHelperCallback;
import com.example.zm.text3.ui.a9_activity.recycler_adapter.RecyclerViewAdapter;

/**
 * Created by zm on 2016/12/7.
 */

public class RecyclerListFragment extends Fragment {
    public RecyclerListFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity());
        //参数view即为我们在onCreateView中return的view
        RecyclerView recyclerView = (RecyclerView)view;
        //固定recyclerview大小
        recyclerView.setHasFixedSize(true);
        //设置adapter
        recyclerView.setAdapter(adapter);
        //设置布局类型为LinearLayoutManager，相当于ListView的样式
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //关联ItemTouchHelper和RecyclerView,实现拖动和侧滑删除
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mItem = new ItemTouchHelper(callback);
        mItem.attachToRecyclerView(recyclerView);
    }
}
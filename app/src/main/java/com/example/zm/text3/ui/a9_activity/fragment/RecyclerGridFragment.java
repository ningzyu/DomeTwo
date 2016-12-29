package com.example.zm.text3.ui.a9_activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

public class RecyclerGridFragment extends Fragment {
    public RecyclerGridFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity());
        RecyclerView recyclerView = (RecyclerView)view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        //只有这里和RecyclerListFragment不一样，这里我们指定布局为GridView样式，2列
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));


        //关联ItemTouchHelper和RecyclerView,实现拖动
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper mItem = new ItemTouchHelper(callback);
        mItem.attachToRecyclerView(recyclerView);
    }
}
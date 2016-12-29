package com.example.zm.text3.ui.a9_activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zm.text3.R;
import com.example.zm.text3.ui.a9_activity.fragment.MainFragment;
import com.example.zm.text3.ui.a9_activity.fragment.RecyclerGridFragment;
import com.example.zm.text3.ui.a9_activity.fragment.RecyclerListFragment;

public class Recycler04 extends AppCompatActivity implements MainFragment.onListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler04);
        //当savedInstanceState为null时才new一个MainFragment出来
        //否则每次旋转屏幕都会new出来一个
        if (savedInstanceState == null){
            MainFragment fragment = new MainFragment();
            //用add将MainFragment添加到framelayout上
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content,fragment)
                    .commit();
        }
    }


    @Override
    public void onListItemClick(int position) {
        //当MainFragment的Item被点击后，就会回调此方法
        //在此方法中写真正的逻辑，这样Activity和Fragment
        //之间就是松耦合关系，MainFragment可以复用
        Fragment fragment = null;
        switch (position){
            case 0:
                //当点击第一个item时候，new一个RecyclerListFragment
                fragment = new RecyclerListFragment();
                break;
            case 1:
                //当点击第二个item时候，new一个RecyclerGridFragment
                fragment = new RecyclerGridFragment();
                break;
        }
        //这次用replace，替换framelayout的布局，也就是MainFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content,fragment)
                .addToBackStack(null)
                .commit();
    }
}

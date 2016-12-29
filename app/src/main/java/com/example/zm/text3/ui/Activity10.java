package com.example.zm.text3.ui;

import android.app.Fragment;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.ui.a10_fragment.A10_f01;
import com.example.zm.text3.ui.a10_fragment.A10_f02;
import com.example.zm.text3.ui.a10_fragment.A10_f03;

import java.util.ArrayList;
import java.util.List;

public class Activity10 extends BaseActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    public ViewPager viewPager;
    public List<Fragment> list = new ArrayList<>();
    private TextView tv0, tv1, tv2;
    private ImageView iv0, iv1, iv2;
    private PagerAdapter ada = new FragmentPagerAdapter(getFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);
        initToolBar(getIntent().getStringExtra("string"), true);
        initView();

        list.add(new A10_f01());
        list.add(new A10_f02());
        list.add(new A10_f03());

        viewPager.setOffscreenPageLimit(list.size());
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(ada);
        selectedBar(0);
        //setUserVisibleHint方法可实现在fragment可见时才进行数据加载操作，即Fragment的懒加载。
        list.get(0).setUserVisibleHint(true);
    }

    /**
     * Fragment管理
     * @param i
     */
    //初始化数据
    void selectedBar(int i) {
        resetBar();//初始化图标与文字颜色
        switch (i) {
            case 0:
                //参数1为viewpager的下标，false表示无动画滚动，就是直接改变正在显示的View
                viewPager.setCurrentItem(0, false);
                tv0.setTextColor(getResources().getColor(R.color.colorPrimary));
                iv0.setImageResource(R.drawable.bar01);
                break;
            case 1:
                viewPager.setCurrentItem(1, false);
                tv1.setTextColor(getResources().getColor(R.color.colorPrimary));
                iv1.setImageResource(R.drawable.bar11);
                break;
            case 2:
                iv2.setImageResource(R.drawable.bar21);
                viewPager.setCurrentItem(2, false);
                tv2.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;

            default:
        }
    }

    private void resetBar() {
        iv0.setImageResource(R.drawable.bar00);
        iv1.setImageResource(R.drawable.bar10);
        iv2.setImageResource(R.drawable.bar20);

        tv0.setTextColor(getResources().getColor(R.color.white));
        tv1.setTextColor(getResources().getColor(R.color.white));
        tv2.setTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar0:
                selectedBar(0);
                break;
            case R.id.bar1:
                selectedBar(1);
                break;
            case R.id.bar2:
                selectedBar(2);
                break;


        }
    }
    /**
     *     实现ViewPager监听事件后需实现的三个方法
     */
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }
    @Override//当页面改变时 参数为索引
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                selectedBar(0);
                break;
            case 1:
                selectedBar(1);
                break;
            case 2:
                selectedBar(2);
                break;

        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    private void initView() {
        findViewById(R.id.bar0).setOnClickListener(this);
        findViewById(R.id.bar1).setOnClickListener(this);
        findViewById(R.id.bar2).setOnClickListener(this);
        tv0 = (TextView) findViewById(R.id.textView_bar0);
        tv1 = (TextView) findViewById(R.id.textView_bar1);
        tv2 = (TextView) findViewById(R.id.textView_bar2);

        iv0 = (ImageView) findViewById(R.id.imageView_bar0);
        iv1 = (ImageView) findViewById(R.id.imageView_bar1);
        iv2 = (ImageView) findViewById(R.id.imageView_bar2);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

    }
}

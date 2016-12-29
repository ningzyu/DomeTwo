package com.example.zm.text3.view;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.toos.Toos;

import java.util.ArrayList;

/**
 * Created by zm on 2016/12/19.
 */

public class MyBanner1 extends FrameLayout {
    private ViewPager vp;
    private  String[] img;//图片数组
    private LinearLayout ll;//白点·
    private ArrayList<ImageView> imaList;//图片的集合
    private Boolean flag;
    private Context context;
    private Handler handler=new Handler();

    public MyBanner1(Context context) {
        this(context,null);
    }
    public MyBanner1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        LayoutInflater.from(getContext()).inflate(R.layout.activity_13, this, true);
        vp = (ViewPager) findViewById(R.id.vp_13);
        ll= (LinearLayout) findViewById(R.id.point_container);
    }
    public MyBanner1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;


    }
    public void initData(String [] img) {
        this.img=img;
        flag=true;
        initViews();//初始化布局
        initAdapter();
        if(flag){
            startPlay();
        }
    }


    private void startPlay(){
        flag=true;
        //实现自动轮播
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(runnableUi);
                }
            }
        }).start();
    }

    // 构建Runnable对象，在runnable中更新界面
    Runnable   runnableUi=new  Runnable(){
        @Override
        public void run() {
            vp.setCurrentItem(vp.getCurrentItem() + 1);
        }

    };
    private void initViews() {
        ImageView iv;
        imaList = new ArrayList<ImageView>();
        View pointview;
        for (int i = 0; i < img.length; i++) {
            iv = new ImageView(context);
//            iv.setImageResource(img[i]);
            Toos.getImg(context,img[i],iv);
            imaList.add(iv);
            //加小白点
            pointview =new View(context);
            pointview.setEnabled(false);
            pointview.setBackgroundResource(R.drawable.selector);
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(15,15);
//            params.gravity= Gravity.CENTER;
            if(i!=0)
                params.leftMargin=10;
            ll.addView(pointview, params );
            final int finalI = i;
            imaList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"这是第"+ finalI +"张图",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private void initAdapter() {
        ll.getChildAt(0).setEnabled(true);
        vp.setAdapter(new MyAdapter());
        vp.setCurrentItem(Integer.MAX_VALUE/2+2);//这里以一个%5为0的数开始，这样打开默认会在第0个item显示
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<ll.getChildCount();i++){
                    ll.getChildAt(i).setEnabled(false);
                }
                ll.getChildAt(position%img.length).setEnabled(true);//设置小白点
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class MyAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int newposition =position%img.length;//得到新位置
            ImageView imageView=imaList.get(newposition);
//            container.addView(imageView);
            return imageView;//把View对象返回给框架，必须重写
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override //判断复用
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


    }


}

package com.example.zm.text3.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.toos.Toos;

import java.util.ArrayList;
import java.util.List;

public class Activity13 extends BaseActivity{
    private ViewPager vp;
    private  String[] img;//图片数组
    private List<String> imgs=new ArrayList<>();
    private LinearLayout ll;//白点·
    private ArrayList<ImageView> imaList;//图片的集合
    private Boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_13);
        initToolBar(getIntent().getStringExtra("string"), true);
        initViews();//初始化布局
        initAdapter();//适配器
        startPlay();//开启轮播
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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            vp.setCurrentItem(vp.getCurrentItem() + 1);
                        }
                    });
                }
            }
        }).start();
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
    //关闭
    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag=false;
    }


    private void initViews() {
        vp = (ViewPager) findViewById(R.id.vp_13);
        ll= (LinearLayout) findViewById(R.id.point_container);
        //图片数组
        imgs.add("http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s780iy3sj20g40arwgt.jpg");
        imgs.add("http://ww4.sinaimg.cn/mw690/b2b1bff9jw1f8s783pdvrj20g40ardi2.jpg");
        imgs.add("http://ww2.sinaimg.cn/mw690/b2b1bff9jw1f8s786bhw6j20go0b4wga.jpg");
        imgs.add("http://ww3.sinaimg.cn/mw690/006qenDXgw1f772en4ixjj31cs0wjn2n.jpg");
        img=new String[imgs.size()];
        for (int j=0;j<imgs.size();j++){
            img[j]=imgs.get(j);
        }



        ImageView iv;
        imaList = new ArrayList<ImageView>();
        View pointview;
        for (int i = 0; i < img.length; i++) {
            iv = new ImageView(this);
//            iv.setImageResource(img[i]);
            Toos.getImg(this,img[i],iv);
            imaList.add(iv);


            //加小白点
            pointview =new View(this);
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
                    Toast.makeText(Activity13.this,"这是第"+ finalI +"张图",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    class MyAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int newposition =position%img.length;//得到新位置
            ImageView imageView=imaList.get(newposition);
            container.addView(imageView);
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

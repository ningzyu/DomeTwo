package com.example.zm.text3.toos;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.example.zm.text3.R;
import com.squareup.picasso.Picasso;

/**
 * Created by zm on 2016/11/25.
 */

public class Toos {
    public static void getImg(Context context, String path, final ImageView iv){
        Picasso picasso= Picasso.with(context);
        //1路径。加载时显示。失败图。宽高。图片的质量。设置图片样式（方法）.控件
        picasso.load(path).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .config(Bitmap.Config.RGB_565)
                .into(iv);
    }
    public static void getImg1(Context context, String path, final ImageView iv){
        Picasso picasso= Picasso.with(context);
        //1路径。加载时显示。失败图。宽高。图片的质量。设置图片样式（方法）.控件
        picasso.load(path).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .resize(200,500)
                .config(Bitmap.Config.RGB_565)
                .into(iv);
    }
}

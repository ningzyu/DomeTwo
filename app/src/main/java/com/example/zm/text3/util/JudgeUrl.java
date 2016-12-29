package com.example.zm.text3.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by zm on 2016/12/20.
 */

public class JudgeUrl {
    public static void Judge(final Context context, String url) {
        String [] ratio=url.split(".");//拆分字符串
        Log.i("Aaaaaaaaaaaaaaaaaaaaaa",url+"-----编辑框--");
        String tail="";
        String form="";

        for (int i=0;i<ratio.length;i++){
            tail=ratio[ratio.length-1];
        }
        Log.i("Aaaaaaaaaaaaaaaaaaaaaa",tail+"____-----__--"+form);
        switch (tail.toLowerCase()){
            case "mp4":
                form="视频";
                break;
            case "mp3":
                form="音乐";
                break;
            case "jpg":
                form="图片";
                break;
            case "png":
                form="图片";
                break;
            case "apk":
                form="安装包";
                break;
            case "gif":
                form="动态图";
                break;
            default:
                form="没看出来";
                break;
        }
        Toast.makeText(context,form,Toast.LENGTH_SHORT).show();

    }

}

package com.example.zm.text3.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.text.UpdateUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Activity12 extends BaseActivity {
    private String path=    "http://124.163.206.250:8080/PIC.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_12);
        initToolBar(getIntent().getStringExtra("string"), true);
    }

    public void b1(View v){
        UpdateUtil.update(this);

    }


    public static File getFileFromServer(String path, ProgressDialog pd) throws Exception{
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            URL url = new URL(path);//请求网络
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();//请求连接
//					conn.setRequestMethod("GET");    //请求方式
            conn.setConnectTimeout(5000);//有效时间
            int code=conn.getResponseCode();      //请求码
            Log.i("Aaaaaaaaaaaaaaaaa","=----------------"+code+"");
//					if (code==200){//请求码问200是说明访问成功
            //获取到文件的大小
            pd.setMax(conn.getContentLength());//进度条长度为文件大小
            InputStream is = conn.getInputStream();//获得文件
            File file = new File(Environment.getExternalStorageDirectory(), "updata.apk");//获取文件
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[10];//这个是缓冲区，即一次读取10个比特，
            int len ;
            int total=0;
            while((len =bis.read(buffer))!=-1){
                fos.write(buffer, 0, len);
                total+= len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        }
        else{
            return null;
        }
    }


}

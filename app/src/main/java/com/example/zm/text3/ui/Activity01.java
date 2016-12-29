package com.example.zm.text3.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zm.text3.MainActivity;
import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;


public class Activity01 extends BaseActivity{
    private ListView lv;
    private String [] list={"路网监测警告","映辉科技有限公司","","",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
        initToolBar(getIntent().getStringExtra("string"), true);
        lv= (ListView) findViewById(R.id.lv1);
        /* 设置ListView的Adapter */
        lv.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, list));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                click(i);
            }
        });
    }
    public void click(int i){
        switch (i){
            case 0:
                //触发通知跳转
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("alert", true);
                intent.putExtra("alert_num", 1);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                PendingIntent p = PendingIntent.getActivity(Activity01.this, 100,
                        intent, PendingIntent.FLAG_ONE_SHOT);

                Notification notification = new Notification.Builder(Activity01.this)
                        .setContentText("您有" +  1 + "条警告")//通知的内容
                        .setContentTitle(getResources().getString(R.string.app_name))//通知的标题
                        .setContentIntent(p)
                        .setSmallIcon(R.mipmap.ic_launcher)//图标
                        .setAutoCancel(true)
                        .setVibrate(new long[] {1000, 1000, 1000, 1000})
                        .setSound(Uri.parse("android.resource://"+getPackageName()+"/raw/alarm"))
                        .build();
                notificationManager.notify(1, notification);//更新Notification
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }

    }


}

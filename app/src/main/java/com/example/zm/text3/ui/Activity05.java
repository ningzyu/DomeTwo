package com.example.zm.text3.ui;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.toos.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Activity05 extends BaseActivity {
    private ListView lv5;
    private TextView tv;
    private ImageView iv;
    private String time;
    private String [] list={"DateUtils日期选择器",
            "获取手机文件列表","获取系统时间",
            "时间转为毫秒","毫秒转为时间"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_05);
        initToolBar(getIntent().getStringExtra("string"), true);
        initView();
        /* 设置ListView的Adapter */
        lv5.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, list));
        lv5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                click(i);
            }
        });
    }

    public void click(int i){

        switch (i) {
            case 0:
                DateUtils.getInstance().show(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        time=year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日";
                    }
                });
                break;
            case 1:
                Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                fileIntent.setType("*/*");
                fileIntent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(fileIntent, 11);
                break;
            case 2:
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss     ");
                Date curDate=new  Date(System.currentTimeMillis());//获取当前时间
                time=formatter.format(curDate);
                break;
            case 3:
                String s="2017-01-01-01-01";
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
                try {
                    long millionSeconds = sdf1.parse(s).getTime();//毫秒
                    time=s+"转为毫秒"+"\n"+millionSeconds;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                long times = Long.parseLong(String.valueOf("1483203660000"));
                time=sdf.format(new Date(times));
                break;
        }
        tv.setText(time);
    }
    private void initView() {
        lv5= (ListView) findViewById(R.id.lv5);
        tv= (TextView) findViewById(R.id.tv_v5);
        iv= (ImageView) findViewById(R.id.iv_v5);
    }

}

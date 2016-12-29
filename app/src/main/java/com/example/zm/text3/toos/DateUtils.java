package com.example.zm.text3.toos;

import android.app.DatePickerDialog;
import android.content.Context;

import com.example.zm.text3.R;

import java.util.Calendar;

/**
 * Created by zm on 2016/11/3.
 */

public class DateUtils {
    public DatePickerDialog myDialog;
    Calendar calendar = Calendar.getInstance();
    private DateUtils(){}
    private static DateUtils instance = null;
    public static DateUtils getInstance(){
        if(instance == null){
            synchronized (DateUtils.class) {
                if(instance == null){
                    instance = new DateUtils();
                }
            }
        }
        return instance;
    }
    /**
     * 显示日期对话框
     */
    public void show(Context context, DatePickerDialog.OnDateSetListener callBack){
        myDialog = new DatePickerDialog(context,
                R.style.AppTheme, callBack,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        myDialog.show();
    }
}

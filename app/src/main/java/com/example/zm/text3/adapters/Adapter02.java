package com.example.zm.text3.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zm on 2016/11/30.
 */

public class Adapter02  extends BaseAdapter {
    ArrayList<String> mStrings;
    private Context context;
    public void setStrings(ArrayList<String> strings) {
        mStrings = strings;
    }
    public Adapter02(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return mStrings==null?0:mStrings.size();
    }
    @Override
    public Object getItem(int position) {
        return mStrings.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textVie=new TextView(context);
        textVie.setText(mStrings.get(position));
        textVie.setTextSize(22);
        return textVie;
    }
}
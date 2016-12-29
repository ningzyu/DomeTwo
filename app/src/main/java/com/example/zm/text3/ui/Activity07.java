package com.example.zm.text3.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zm.text3.R;
import com.example.zm.text3.adapters.Adapter07;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.entity.DataBean;

import java.util.ArrayList;
import java.util.List;

public class Activity07 extends BaseActivity {
    private Button button;

    private ListView listView;

    private List<DataBean> mDatas;

    private Adapter07 mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_07);
        initToolBar(getIntent().getStringExtra("string"), true);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);

        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            DataBean dataBean = new DataBean("" + i, "上邪", "山无棱，天地合，乃敢与君绝");
            mDatas.add(dataBean);
        }

        mAdapter = new Adapter07(this, mDatas);
        listView.setAdapter(mAdapter);

    }

    /**
     * 编辑、取消编辑
     * @param view
     */
    public void b1(View view) {

        mAdapter.flage = !mAdapter.flage;

        if (mAdapter.flage) {
            button.setText("取消");
        } else {
            button.setText("编辑");
        }

        mAdapter.notifyDataSetChanged();
    }

    /**
     * 全选
     * @param view
     */
    public void b2(View view) {
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).isCheck = true;
            }

            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 全不选
     * @param view
     */
    public void b3(View view) {

        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                mDatas.get(i).isCheck = false;
            }

            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 反选
     * @param view
     */
    public void b4(View view) {
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).isCheck) {
                    mDatas.get(i).isCheck = false;
                } else {
                    mDatas.get(i).isCheck = true;
                }
            }

            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 获取选中数据
     * @param view
     */
    public void b5(View view) {
        List<String> ids = new ArrayList<>();
        if (mAdapter.flage) {
            for (int i = 0; i < mDatas.size(); i++) {
                if (mDatas.get(i).isCheck) {
                    ids.add(mDatas.get(i).id);
                }
            }

            Toast.makeText(this,ids.toString(), Toast.LENGTH_SHORT).show();
            Log.e("TAG", ids.toString());
        }
    }
}

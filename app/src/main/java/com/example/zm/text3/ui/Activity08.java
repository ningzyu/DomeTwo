package com.example.zm.text3.ui;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.zm.text3.R;
import com.example.zm.text3.adapters.Adapter08;
import com.example.zm.text3.base.BaseActivity;
import com.example.zm.text3.base.HttpService;
import com.example.zm.text3.entity.Entity_8;

import java.io.IOException;
import java.util.List;

//import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity08 extends BaseActivity {
    private ListView lv;
    private static String path="http://v.juhe.cn/weixin/query?key=78f723dccf85aea324a3cf0daac97f35";
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_08);
        initToolBar(getIntent().getStringExtra("string"), true);
        initView();
//        okhttp();
        getRetrofit();
    }






    private void getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HttpService userBiz = retrofit.create(HttpService.class);
        Call<Entity_8> call = userBiz.getGong2("query","78f723dccf85aea324a3cf0daac97f35");
//        Call<Entity_8> call = userBiz.getGong1("78f723dccf85aea324a3cf0daac97f35");
        call.enqueue(new Callback<Entity_8>()
        {
            @Override
            public void onResponse(Call<Entity_8> call, retrofit2.Response<Entity_8> response) {
                  Entity_8 e8= response.body();
                List<Entity_8.ResultBean.ListBean> data=e8.getResult().getList();
                Adapter08 ada=new Adapter08(Activity08.this,data,R.layout.lv8_item);
                lv.setAdapter(ada);
            }

            @Override
            public void onFailure(Call<Entity_8> call, Throwable t) {

            }
        });
    }
    private void initView() {
        lv= (ListView) findViewById(R.id.lv_v8);
    }

    //    Handler handler=new Handler(){
//        //接受消息的线程
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 0:
//                    Gsons();
//                    break;
//
//            }
//        }
//    };




//
//    private void okhttp() {
//        new OkHttpClient().newCall(new Request.Builder()
//                .url(path)
//                .build()).enqueue(new Callback() {
//            @Override//请求失败
//            public void onFailure(Call call, IOException e) {
//                Log.e("take notes", call.toString() + e);
//            }
//            @Override//请求成功
//            public void onResponse(Call call, Response response) throws IOException {
//                    result=response.body().string();
//                    Message message = new Message();
//                    message.what = 0;
//                    message.obj = result;
//                    handler.sendMessage(message);
//            }
//        });
//    }


//    private void Gsons() {
//        Entity_8 e8= JSON.parseObject(result,Entity_8.class);
//        List<Entity_8.ResultBean.ListBean> data=e8.getResult().getList();
//        Adapter08 ada=new Adapter08(this,data,R.layout.lv8_item);
//        lv.setAdapter(ada);
//    }
}

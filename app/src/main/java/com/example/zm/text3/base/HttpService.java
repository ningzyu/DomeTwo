package com.example.zm.text3.base;

import com.example.zm.text3.entity.Entity_8;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zm on 2016/12/8.
 */

public interface HttpService {

    //"http://v.juhe.cn/weixin/query?key=78f723dccf85aea324a3cf0daac97f35
    //写法1查询参数的设置@Query
    @GET("weixin/query")
    Call<Entity_8> getGong1(@Query("key") String sort);//请求网络需要的参数（id，第几页，多少条数据）


    //写法2@ Path的定位就是用于url的路径而不是参数，对于参数还是选择通过@Query来设置
    @GET("weixin/{query}")//大括号中表示链接可选择的类型i,动态的url访问@PATH
    Call<Entity_8> getGong2(@Path("query") String i,@Query("key") String sort);


//    @GET("{username}")动态的url访问@PATH
//    Call<User> getUser(@Path("username") String username);

    /*@GET("weixin/query?key={key}")//大括号中表示链接可选择的类型i
        //链接的类型i，请求网络需要的参数（id，第几页，多少条数据）
    Call<Entity_8> getGong2(@Path("key") String i);*/




//    @POST("add")//@Body这个注解标识我们的参数对象
//    Call<List<User>> addUser(@Body User user);

//    两种requestBody，FormBody以表单的方式传递简单的键值对，
//        @POST("login")
//        @FormUrlEncoded
//        Call<User> login(@Field("username") String username, @Field("password") String password);
//    MultipartBody以POST表单的方式上传文件可以携带参数
//    @Multipart
//    @POST("register")
//    Call<User> registerUser(@Part MultipartBody.Part photo,
//    @Part("username") RequestBody username, @Part("password") RequestBody password);
//
//    @MultiPart的意思就是允许多个@Part了，我们这里使用了3个@Part，第一个我们准备上传个文件，使用了MultipartBody.Part类型，其余两个均为简单的键值对。
//
//    使用：
//
//    File file = new File(Environment.getExternalStorageDirectory(), "icon.png");
//    RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
//    MultipartBody.Part photo = MultipartBody.Part.createFormData("photos", "icon.png", photoRequestBody);
//
//    Call<User> call = userBiz.registerUser(photo, RequestBody.create(null, "abc"), RequestBody.create(null, "123"));


}

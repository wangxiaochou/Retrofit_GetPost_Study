package com.example.ch_wangling.retrofittest002.post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CH_WangLing on 2018/1/4.
 * 创建用于描述网络数据的接口
 */

public interface PostRequest_Interface {

    //这一行是必须的，当POST请求时，@FormUrlEncoded和@Field简单的表单键值对。两个需要结合使用，否则会报错
    @FormUrlEncoded
    //使用@POST方法，进行请求，传入部分网络地址
    @POST("translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
    Call<Translation2> getCall(@Field("i") String targetSentence);
}

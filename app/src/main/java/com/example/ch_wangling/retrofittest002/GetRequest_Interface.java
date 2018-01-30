package com.example.ch_wangling.retrofittest002;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by CH_WangLing on 2018/1/3.
 */

public interface GetRequest_Interface {

    /*
    注解里面传入网络请求的一部分地址
    retrofit把网络请求的URL分成两部分，一部分放在retrofit对象里面，一部分放在网络请求接口里面
    如果接口里面的URL是一个完整的地址，那么在retrofit对象里面的URL可以忽略
    */
    //这里使用的是get方法
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%30world")
    //getCll()是接收网络请求数据的方法
    Call<Translation>getCall();
}

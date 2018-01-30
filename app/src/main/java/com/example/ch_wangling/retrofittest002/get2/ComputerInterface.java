package com.example.ch_wangling.retrofittest002.get2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CH_WangLing on 2018/1/9.
 */
/*
创建用于网络请求的接口
 */

/*
     @GET注解的作用:采用Get方法发送网络请求
     getCall() = 接收网络请求数据的方法
     其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
     如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
 */
public interface ComputerInterface {

    //Retrofit把 网络请求的URL 分成了两部分设置，一部分在接口，一部分在创建Retrofit实例时通过.baseUrl()设置
    @GET("/course_api/wares/hot")
    Call<Computer> getCall(@Query("pageSize") int pageSize,@Query("curPage") int curPage);
}

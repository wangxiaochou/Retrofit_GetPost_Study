package com.example.ch_wangling.retrofittest002;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ch_wangling.retrofittest002.post.PostActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CH_WangLing on 2018/1/3.
 */

public class GetRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_main);

        //使用retrofit的封装方法
        request();
    }

    public void request(){
        //第四步：创建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //第五步：创建网络请求接口的实例
        final GetRequest_Interface request_interface = retrofit.create(GetRequest_Interface.class);
        //对发送的请求进行封装
        Call<Translation> call = request_interface.getCall();

        //第六步：发送网络请求（异步）
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(@NonNull Call<Translation> call,@NonNull Response<Translation> response) {
                try{

                    Log.d("查看输出的是什么",response.body().toString());

                    if (response.body() != null){
                        //第七步：处理返回的数据结果
                        response.body().show();
                    }

                }catch (NullPointerException e){
                    Log.d("这里是异步请求显示之后，是否有异常", e.getMessage());
                }

            }
            //请求失败时回调
            @Override
            public void onFailure(@NonNull Call<Translation> call,@NonNull Throwable t) {
                System.out.println("连接失败");
            }
        });
    }
}

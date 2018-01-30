package com.example.ch_wangling.retrofittest002.get2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.ch_wangling.retrofittest002.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CH_WangLing on 2018/1/9.
 */

public class GetComputer extends AppCompatActivity{

    private TextView tv_7;
    private TextView tv_8;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        tv_7 = (TextView)findViewById(R.id.textView7);
        tv_8 = (TextView)findViewById(R.id.textView8);

        init();
    }

    public void init(){

        //创建retrofit实例
        Retrofit retrofit = new Retrofit.Builder()
                //设置网络请求剩下一部分的请求地址
                .baseUrl("http://112.124.22.238:8081/")
                //设置数据解析器，这里是谷歌官方的gson数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                //最后使用build方法
                .build();

        //创建网络请求接口的实例，将网络请求接口实例化
        ComputerInterface computerInterface = retrofit.create(ComputerInterface.class);

        //对发送的请求进行封装
        Call<Computer> call = computerInterface.getCall(10,1);

        //call.enqueue异步请求数据方法
        call.enqueue(new Callback<Computer>() {
            @Override
            //请求成功时回调
            public void onResponse(@NonNull Call<Computer> call,@NonNull Response<Computer> response) {
                //注意此时会出现的空指针异常
                //对返回数据进行处理
                try{
                    //输出数据
                    tv_7.setText(response.body(). getList().get(0).getName());
                    tv_8.setText(String.valueOf(response.body().getList().get(0).getPrice()));
                    Log.d("这里是输出",response.body(). getList().get(0).getName());
                }catch (NullPointerException e){
                    Log.d("查看是否有异常抛出，异常如下", e.getMessage());
                }
            }

            //请求失败时回调，结果的处理，以及日志的实现
            @Override
            public void onFailure(@NonNull Call<Computer> call,@NonNull Throwable t) {
                System.out.println("请求失败");
                System.out.println(t.getMessage());
            }
        });
    }
}

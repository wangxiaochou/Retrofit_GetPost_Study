package com.example.ch_wangling.retrofittest002.post;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ch_wangling.retrofittest002.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CH_WangLing on 2018/1/4.
 */

public class PostActivity extends AppCompatActivity{

    private EditText et_1;
    private TextView tv_1;
    private Button btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        et_1 = (EditText)findViewById(R.id.edittext);
        tv_1 = (TextView)findViewById(R.id.textView);
        btn_2 = (Button)findViewById(R.id.button2);

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建请求方法
                post_request();
            }
        });
    }

    public void post_request(){
        //新建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                //传入部分网络地址
                .baseUrl("http://fanyi.youdao.com/")
                //采用gson数据处理格式，解析数据
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //创建网络请求接口的实例
        PostRequest_Interface postRequest_interface = retrofit.create(PostRequest_Interface.class);

        //对发送的请求，进行封装
        Call<Translation2> call = postRequest_interface.getCall(et_1.getText().toString());

        //发送网络请求（异步）
        call.enqueue(new Callback<Translation2>() {
            //请求成功时的回调
            @Override
            public void onResponse(@NonNull Call<Translation2> call,@NonNull Response<Translation2> response) {
                //注意这里可能会出现异常，捕捉空指针异常
                try {
                    //处理返回数据结果
                    System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
                    tv_1.setText(response.body().getTranslateResult().get(0).get(0).getTgt());
                }catch(NullPointerException e){
                    Log.d("查看是否有异常抛出，异常如下", "e");
                }

            }

            //请求失败时的回调
            @Override
            public void onFailure(@NonNull Call<Translation2> call,@NonNull Throwable t) {
                System.out.println("请求失败");
                System.out.println(t.getMessage());
            }
        });
    }
}

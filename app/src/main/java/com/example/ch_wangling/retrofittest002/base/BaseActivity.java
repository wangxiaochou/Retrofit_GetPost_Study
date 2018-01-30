package com.example.ch_wangling.retrofittest002.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ch_wangling.retrofittest002.GetRequest;
import com.example.ch_wangling.retrofittest002.R;
import com.example.ch_wangling.retrofittest002.get2.GetComputer;
import com.example.ch_wangling.retrofittest002.post.PostActivity;

/**
 * Created by CH_WangLing on 2018/1/10.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        btn_1 = (Button)findViewById(R.id.button3);
        btn_2 = (Button)findViewById(R.id.button4);
        btn_3 = (Button)findViewById(R.id.button5);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button3:
                Intent intent1 = new Intent(BaseActivity.this, GetRequest.class);
                startActivity(intent1);
                break;
            case R.id.button4:
                Intent intent2 = new Intent(BaseActivity.this, PostActivity.class);
                startActivity(intent2);
                break;
            case R.id.button5:
                Intent intent3 = new Intent(BaseActivity.this, GetComputer.class);
                startActivity(intent3);
                break;
        }
    }
}

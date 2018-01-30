package com.example.ch_wangling.retrofittest002;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CH_WangLing on 2018/1/3.
 * 根据API的数据格式，创建接收服务器返回数据的类
 */

public class Translation {

    private int status;

    private content content;
    private static class content{
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNu;
    }

    //定义返回数据的方法
     public void show() {
         System.out.println(status);
         System.out.println(content.from);
         System.out.println(content.to);
         System.out.println(content.vendor);
         System.out.println(content.out);
         System.out.println(content.errNu);
     }
}

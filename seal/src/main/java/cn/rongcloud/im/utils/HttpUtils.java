package cn.rongcloud.im.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 皓旭 on 2017/4/13.
 */

public class HttpUtils {
    public static void getNewsJson(final String url,final Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection;
                InputStream is;
                try {
                    connection= (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("GET");
                    is=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                    String line="";
                    StringBuilder result=new StringBuilder();
                    while ((line=reader.readLine())!=null){
                        result.append(line);
                    }
                    Message msg=new Message();
                    msg.obj=result.toString();
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static void setPicBitmap(final ImageView ivpic,final String pic_url){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection connection= (HttpURLConnection) new URL(pic_url).openConnection();
                    connection.connect();
                    InputStream is=connection.getInputStream();
                    Bitmap bitmap=BitmapFactory.decodeStream(is);
                    ivpic.setImageBitmap(bitmap);
                    is.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

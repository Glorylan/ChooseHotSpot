package com.woker.choosehotspot.activity.util;

import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Blues on 2017/11/4.
 */

    //okhttp用于get请求
public class HttpUtil {
    public static void sendOKHttpRequest(String address, okhttp3.Callback callback) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

    //okhttp用于post请求
    public static void sendOkHttpPostRequest(final String address, Map<String, String> map, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        //    参数传递
        FormBody.Builder builder = new FormBody.Builder();

        Set<String> keySet = map.keySet();
        for (String i : keySet) {
            //从集合中一一取到对应的key和value
            String str = map.get(i);
            builder.add(i, str);

        }
        Request request = new Request.Builder()
                .url(address)
                .post(builder.build())
//                .addHeader("", "")    //设置请求头
                .build();
        client.newCall(request).enqueue(callback);
    }
}


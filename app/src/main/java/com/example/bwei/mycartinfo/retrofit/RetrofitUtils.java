package com.example.bwei.mycartinfo.retrofit;

import com.example.bwei.mycartinfo.data.api.Constant;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QinQinBaoBei on 2018/1/6.
 */

public class RetrofitUtils {

    private static  RetrofitUtils retrofitUtils=null;
    private final Retrofit retrofit;
    private static OkHttpClient.Builder builder;

    private RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ADDCART)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    //写一个公共的方法用来调用
    public static RetrofitUtils getInstance(){
         if(retrofitUtils==null){
              synchronized (RetrofitUtils.class){
                  if( null == retrofitUtils){
                      if(builder==null) {
                          builder = new OkHttpClient.Builder();
                          builder.readTimeout(20, TimeUnit.SECONDS);
                          builder.writeTimeout(20, TimeUnit.SECONDS);
                          builder.connectTimeout(20, TimeUnit.SECONDS);
                          builder.build();
                      }
                      retrofitUtils = new RetrofitUtils();
                  }
              }
         }
        return retrofitUtils;
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }


}

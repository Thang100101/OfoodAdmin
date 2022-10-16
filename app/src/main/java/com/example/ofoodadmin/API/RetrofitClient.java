package com.example.ofoodadmin.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String baseUrl;

    public static Retrofit getInstance(String url){
        if(retrofit == null || !baseUrl.equals(url)){
            return getRetrofit(url);
        }
        return retrofit;
    }
    private static synchronized Retrofit getRetrofit(String url){
        if(retrofit == null || !baseUrl.equals(url)){
            baseUrl = url;
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            return retrofit;
        }
        return retrofit;
    }
}

package com.daud.postapitask2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AllOrderRetro {
    public static String BASEURL = "https://restaurant.bdtask.com/demo/V3/";

    public static Gson gson =new GsonBuilder().setLenient().create();

    public static Retrofit getRetro(){
        return new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}

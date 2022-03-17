package com.daud.postapitask2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AllOrderinterface {
    @FormUrlEncoded
    @POST("allonlineorder")
    Call<AllOrderMc> getData(@Field("id") String id,@Field("kitchenid") String kitchenid);
}

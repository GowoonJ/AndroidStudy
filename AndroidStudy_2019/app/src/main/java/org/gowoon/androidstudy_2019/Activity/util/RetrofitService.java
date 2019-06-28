package org.gowoon.androidstudy_2019.Activity.util;

import com.google.gson.JsonObject;

import org.gowoon.androidstudy_2019.Activity.model.ResultRetrofitTest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {
    @FormUrlEncoded
    @POST("/posts")
    Call<JsonObject>
    examplePost();

    @FormUrlEncoded
    @POST("/posts")
    Call<ResultRetrofitTest>
    examplePostModel();

    @GET("/posts")
    Call<JsonObject> exampleGet();
}

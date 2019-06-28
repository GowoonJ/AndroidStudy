package org.gowoon.androidstudy_2019.Activity.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SingletonKotlin {
    val retrofit = Retrofit.Builder()
            .baseUrl(Config.serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
}
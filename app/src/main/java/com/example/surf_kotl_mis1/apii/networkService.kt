package com.example.myapplication4.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object networkService {

    private var mRetrofitPostLogin: Retrofit = Retrofit.Builder()
            .baseUrl("https://r2.mocker.surfstudio.ru/android_vsu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun<T> buildService(service: Class<T>): T{
        return mRetrofitPostLogin.create(service)
    }
}
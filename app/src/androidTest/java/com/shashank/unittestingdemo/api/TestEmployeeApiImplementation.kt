package com.shashank.unittestingdemo.api

import com.shashank.unittestingdemo.core.Constants
import com.shashank.unittestingdemo.model.api.RetrofitInstance
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TestEmployeeApiImplementation {
    val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    val client = OkHttpClient.Builder().apply {
        this.addInterceptor(intercepter)
            // time out setting
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(25, TimeUnit.SECONDS)
    }.build()

    fun provideApi(): TestEmployeeApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(RetrofitInstance.client)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(TestEmployeeApi::class.java)
}
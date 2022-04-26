package com.example.todo.sidedish.di

import com.example.todo.sidedish.common.Constants
import com.example.todo.sidedish.config.ORDER_BASE_URL
import com.example.todo.sidedish.data.remote.OnBanApi
import com.example.todo.sidedish.data.remote.order.OrderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Singleton
    @Provides
    @MenuRetrofit
    fun retrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    @OrderRetrofit
    fun orderRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ORDER_BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun menuService(@MenuRetrofit retrofit: Retrofit): OnBanApi = retrofit.create(OnBanApi::class.java)

    @Singleton
    @Provides
    fun orderService(@OrderRetrofit retrofit: Retrofit): OrderApi = retrofit.create(OrderApi::class.java)
}
package com.codesquadhan.sidedish.di

import com.codesquadhan.sidedish.network.DetailService
import com.codesquadhan.sidedish.network.LoginService
import com.codesquadhan.sidedish.network.MenuService
import com.codesquadhan.sidedish.ui.common.Common
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://3.34.207.233:8080/"  // 로그인 필요 서버
    //private const val BASE_URL = "http://3.38.230.108:8080/"  // 로그인 필요없는 서버

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MenuService {
        return retrofit.create(MenuService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailApiService(retrofit: Retrofit): DetailService {
        return retrofit.create(DetailService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginApiService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    class AppInterceptor @Inject constructor() : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain) : Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Cookie", Common.JESSIONID)
                .build()
            proceed(newRequest)
        }
    }

}
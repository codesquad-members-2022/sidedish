package com.example.sidedish.di

import com.example.sidedish.data.MenuListDataSource
import com.example.sidedish.data.MenuListRepository
import com.example.sidedish.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.codesquad.kr"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logger = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    @Provides
    @Singleton
    fun create(okHttpClient: OkHttpClient): ApiClient {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMenuDataSource(apiClient: ApiClient): MenuListDataSource {
        return MenuListDataSource(apiClient)
    }

}


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        menuListDataSource: MenuListDataSource
    ): MenuListRepository {
        return MenuListRepository(menuListDataSource)
    }

}

package com.example.sideDish.di

import com.example.sideDish.network.OrderRetrofitService
import com.example.sideDish.network.SideDishRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): SideDishRetrofitService {
        return SideDishRetrofitService.create()
    }

    @Singleton
    @Provides
    fun provideOrderRetrofitService(): OrderRetrofitService {
        return OrderRetrofitService.create()
    }

}
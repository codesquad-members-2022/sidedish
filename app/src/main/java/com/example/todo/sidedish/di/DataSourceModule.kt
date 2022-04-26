package com.example.todo.sidedish.di

import com.example.todo.sidedish.data.remote.DataSource
import com.example.todo.sidedish.data.remote.OnBanApi
import com.example.todo.sidedish.data.remote.OnBanDataSource
import com.example.todo.sidedish.data.remote.order.OrderApi
import com.example.todo.sidedish.data.remote.order.OrderDataSource
import com.example.todo.sidedish.data.remote.order.OrderRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideOnBanDataSource(api: OnBanApi): DataSource {
        return OnBanDataSource(api)
    }

    @Provides
    @Singleton
    fun provideOrderRemoteDataSource(api: OrderApi): OrderDataSource {
        return OrderRemoteDataSource(api)
    }
}
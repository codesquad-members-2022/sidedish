package com.example.todo.sidedish.di

import com.example.todo.sidedish.data.remote.DataSource
import com.example.todo.sidedish.data.remote.OnBanApi
import com.example.todo.sidedish.data.remote.OnBanDataSource
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
}
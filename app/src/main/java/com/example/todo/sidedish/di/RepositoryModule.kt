package com.example.todo.sidedish.di

import com.example.todo.sidedish.data.remote.OnBanDataSource
import com.example.todo.sidedish.data.repository.MenuRepositoryImpl
import com.example.todo.sidedish.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMenuRepository(onBanDataSource: OnBanDataSource): Repository {
        return MenuRepositoryImpl(onBanDataSource)
    }
}
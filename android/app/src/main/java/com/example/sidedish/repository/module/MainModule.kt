package com.example.sidedish.repository.module

import com.example.sidedish.repository.MainDataSource
import com.example.sidedish.repository.MainRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindRepository(mainRemoteDataSource: MainRemoteDataSource): MainDataSource
}
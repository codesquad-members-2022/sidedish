package com.example.sidedish.repository.module

import com.example.sidedish.repository.ProductCountRemoteDataSource
import com.example.sidedish.repository.ProductCountRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductCountModule {

    @Binds
    abstract fun bindRepository(productCountRemoteDataSourceImpl: ProductCountRemoteDataSourceImpl): ProductCountRemoteDataSource
}
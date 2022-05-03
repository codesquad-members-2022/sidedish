package com.example.sidedish.repository.module

import com.example.sidedish.repository.ProductDetailRemoteDataSource
import com.example.sidedish.repository.ProductDetailRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductDetailModule {

    @Binds
    abstract fun bindRepository(productDetailRemoteDataSourceImpl: ProductDetailRemoteDataSourceImpl): ProductDetailRemoteDataSource
}
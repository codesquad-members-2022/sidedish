package com.example.sideDish.di

import com.example.sideDish.data.source.DetailRemoteRepository
import com.example.sideDish.data.source.DetailRepository
import com.example.sideDish.data.source.FoodRemoteRepository
import com.example.sideDish.data.source.FoodRepository
import com.example.sideDish.network.SideDishRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideDetailRepository(retrofitService: SideDishRetrofitService): DetailRepository {
        return DetailRemoteRepository(retrofitService)
    }

    @Singleton
    @Provides
    fun provideFoodRepository(retrofitService: SideDishRetrofitService): FoodRepository {
        return FoodRemoteRepository(retrofitService)
    }
}

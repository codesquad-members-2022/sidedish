package com.example.sideDish.di

import com.example.sideDish.data.source.*
import com.example.sideDish.network.OrderRetrofitService
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

    @Singleton
    @Provides
    fun provideOrderRepository(orderRetrofitService: OrderRetrofitService): OrderRepository {
        return OrderRepository(orderRetrofitService)
    }

}

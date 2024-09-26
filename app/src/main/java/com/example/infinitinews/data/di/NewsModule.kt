package com.example.infinitinews.data.di

import com.example.infinitinews.data.di.AnalyticsModule.provideNetworkService
import com.example.infinitinews.data.repository.NewsRepository
import com.example.infinitinews.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object NewsModule {

    @Provides
    fun provideNewsRepository(
    ): NewsRepository {
        return NewsRepositoryImpl(provideNetworkService())
    }

}
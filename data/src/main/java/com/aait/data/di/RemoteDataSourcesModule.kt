package com.aait.data.di

import com.aait.data.datasource.HomeDataSource
import com.aait.data.remote.datasource.HomeDataSourceImpl
import com.aait.data.remote.endpoints.HomeEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourcesModule {

    @Provides
    @Singleton
    fun provideHomeRemoteDataSource(homeEndPoints: HomeEndPoints): HomeDataSource =
        HomeDataSourceImpl(homeEndPoints)
}
package com.a1.data.di

import com.a1.data.datasource.HomeDataSource
import com.a1.data.local.endpoints.MainDao
import com.a1.data.remote.datasource.HomeDataSourceImpl
import com.a1.data.remote.endpoints.HomeEndPoints
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
    fun provideHomeRemoteDataSource(
        homeEndPoints: HomeEndPoints,
        mainDao: MainDao
    ): HomeDataSource =
        HomeDataSourceImpl(homeEndPoints, mainDao)
}
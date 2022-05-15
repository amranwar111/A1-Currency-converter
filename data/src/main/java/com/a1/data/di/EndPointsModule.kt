package com.a1.data.di

import com.a1.data.remote.endpoints.HomeEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EndPointsModule {

    @Provides
    @Singleton
    fun provideHomeEndPoints(retrofit: Retrofit): HomeEndPoints =
        retrofit.create(HomeEndPoints::class.java)
}
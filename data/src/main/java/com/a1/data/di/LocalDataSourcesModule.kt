package com.a1.data.di

import android.content.Context
import androidx.room.Room
import com.a1.data.local.datasource.ILocalDataSource
import com.a1.data.local.datasource.LocalDataSourceImpl
import com.a1.data.local.endpoints.MainDao
import com.a1.data.local.datasource.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourcesModule {

    @Singleton
    @Provides
    fun provideMainDAO(blogDatabase: MainDatabase): MainDao {
        return blogDatabase.mainDao()
    }

    @Singleton
    @Provides
    fun provideMainDb(@ApplicationContext context: Context): MainDatabase {
        return Room
            .databaseBuilder(
                context,
                MainDatabase::class.java,
                MainDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideILocalDataSource(localDataSourceImpl: LocalDataSourceImpl): ILocalDataSource {
        return localDataSourceImpl
    }
}
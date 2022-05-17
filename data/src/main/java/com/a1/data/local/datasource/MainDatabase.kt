package com.a1.data.local.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.a1.data.local.endpoints.MainDao
import com.a1.domain.entities.Operations

@Database(entities = [Operations::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract fun mainDao(): MainDao

    companion object {
        const val DATABASE_NAME: String = "main_db"
    }
}
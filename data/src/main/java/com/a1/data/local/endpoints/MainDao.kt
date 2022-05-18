package com.a1.data.local.endpoints

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a1.domain.entities.Operations

@Dao
interface MainDao {

    // 259200000 is refers to 3 days in milliseconds
    @Query("SELECT * FROM operations WHERE (:currentDate - date) < 259200000")
    fun getAllOperations(currentDate: Long): List<Operations>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOperation(vararg operation: Operations)
}
package com.a1.data.local.endpoints

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a1.domain.entities.Operations

@Dao
interface MainDao {

    @Query("SELECT * FROM operations WHERE :currentDate > 0 ")
    fun getAllOperations(currentDate: Long): List<Operations>
/*
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOperation(vararg operation: Operations)

    /*   @Delete
       fun delete(user: User)

   */
}
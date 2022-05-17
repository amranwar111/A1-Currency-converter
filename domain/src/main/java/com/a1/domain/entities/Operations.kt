package com.a1.domain.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "operations")
data class Operations(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "from") val from: String,
    @ColumnInfo(name = "to") val to: String,
    @ColumnInfo(name = "fromValue") val fromValue: Float,
    @ColumnInfo(name = "toValue") val toValue: Float,
    @ColumnInfo(name = "date") val date: Long
)
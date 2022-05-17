package com.a1.data.local.datasource

import com.a1.domain.entities.Operations


interface ILocalDataSource {

    suspend fun saveOperation(operations: Operations)
    suspend fun getOperations(date: Long): List<Operations>
}
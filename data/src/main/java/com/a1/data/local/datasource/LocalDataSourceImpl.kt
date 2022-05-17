package com.a1.data.local.datasource

import com.a1.data.local.endpoints.MainDao
import com.a1.domain.entities.Operations
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val mainDao: MainDao) : ILocalDataSource {

    override suspend fun saveOperation(operations: Operations) {
        return mainDao.insertOperation(operations)
    }

    override suspend fun getOperations(date: Long): List<Operations> {
        return mainDao.getAllOperations(date)
    }
}
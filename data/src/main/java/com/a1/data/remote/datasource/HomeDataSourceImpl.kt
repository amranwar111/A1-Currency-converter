package com.a1.data.remote.datasource

import com.a1.data.datasource.HomeDataSource
import com.a1.data.local.endpoints.MainDao
import com.a1.data.remote.endpoints.HomeEndPoints
import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val homeEndPoints: HomeEndPoints,
    private val mainDao: MainDao
) :
    HomeDataSource {

    override suspend fun getCurrencies(key: String): BaseResponse<CurrenciesResponse> {
        return BaseResponse(data = homeEndPoints.getCurrencies(key))
    }

    override suspend fun insertOperations(operations: Operations): BaseResponse<Unit> {
        return BaseResponse(data = mainDao.insertOperation(operations))
    }

    override suspend fun getOperations(date: Long): BaseResponse<List<Operations>> {
        return BaseResponse(data = mainDao.getAllOperations(date))
    }
}
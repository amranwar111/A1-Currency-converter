package com.a1.data.datasource

import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations

interface HomeDataSource {

    suspend fun getCurrencies(key: String): BaseResponse<CurrenciesResponse>
    suspend fun insertOperations(operations: Operations): BaseResponse<Unit>
    suspend fun getOperations(date: Long): BaseResponse<List<Operations>>
}
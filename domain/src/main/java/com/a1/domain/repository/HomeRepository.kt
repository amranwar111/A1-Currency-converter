package com.a1.domain.repository

import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.util.DataState
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getCurrencies(key: String): Flow<DataState<BaseResponse<CurrenciesResponse>>>
}
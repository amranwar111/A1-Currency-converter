package com.a1.data.datasource

import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse

interface HomeDataSource {

    suspend fun getCurrencies(key: String): BaseResponse<CurrenciesResponse>
}
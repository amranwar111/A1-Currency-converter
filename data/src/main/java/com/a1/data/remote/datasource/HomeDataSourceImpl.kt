package com.a1.data.remote.datasource

import com.a1.data.datasource.HomeDataSource
import com.a1.data.remote.endpoints.HomeEndPoints
import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(private val homeEndPoints: HomeEndPoints) :
    HomeDataSource {

    override suspend fun getCurrencies(key: String): BaseResponse<CurrenciesResponse> {
        return homeEndPoints.getCurrencies(key)
    }
}
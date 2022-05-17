package com.a1.data.repository

import com.a1.data.datasource.HomeDataSource
import com.a1.data.local.utils.safeCacheCall
import com.a1.data.remote.utils.safeApiCall
import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations
import com.a1.domain.repository.HomeRepository
import com.a1.domain.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeDataSource: HomeDataSource) :
    HomeRepository {

    override suspend fun getCurrencies(key: String): Flow<DataState<BaseResponse<CurrenciesResponse>>> =
        safeApiCall { homeDataSource.getCurrencies(key) }

    override suspend fun insertOperation(operations: Operations): Flow<DataState<BaseResponse<Unit>>> =
        safeCacheCall(Dispatchers.IO) { homeDataSource.insertOperations(operations) }

    override suspend fun getLocalOperation(date: Long): Flow<DataState<BaseResponse<List<Operations>>>> =
        safeCacheCall(Dispatchers.IO) { homeDataSource.getOperations(date) }

}
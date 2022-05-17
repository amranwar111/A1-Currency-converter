package com.a1.data.remote.endpoints

import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeEndPoints {
    @GET("latest")
    suspend fun getCurrencies(
        @Query("access_key") accessKey: String,
    ): CurrenciesResponse
}
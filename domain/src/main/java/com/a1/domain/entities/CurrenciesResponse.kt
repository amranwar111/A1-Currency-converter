package com.a1.domain.entities

import com.squareup.moshi.Json

data class CurrenciesResponse(

    @Json(name = "date")
    val date: String? = null,

    @Json(name = "success")
    val success: Boolean? = null,

    @Json(name = "rates")
    val rates: Map<String, String>? = null,

    @Json(name = "timestamp")
    val timestamp: Int? = null,

    @Json(name = "base")
    val base: String? = null
)
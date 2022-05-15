package com.aait.domain.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class BaseResponse<T>(
    @Json(name = "key") val key: String,
    @Json(name = "data") val data: T?,
    @Json(name = "msg") val msg: String,
) : Serializable
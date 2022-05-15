package com.a1.data.remote.datasource

import com.a1.data.datasource.HomeDataSource
import com.a1.data.remote.endpoints.HomeEndPoints
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(private val homeEndPoints: HomeEndPoints) :
    HomeDataSource {
}
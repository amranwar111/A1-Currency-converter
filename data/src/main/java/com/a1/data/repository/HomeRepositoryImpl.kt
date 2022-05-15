package com.a1.data.repository

import com.a1.data.datasource.HomeDataSource
import com.a1.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeDataSource: HomeDataSource) :
    HomeRepository {

}
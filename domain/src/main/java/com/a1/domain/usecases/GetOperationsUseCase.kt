package com.a1.domain.usecases

import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations
import com.a1.domain.repository.HomeRepository
import com.a1.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOperationsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(
        date: Long
    ): Flow<DataState<BaseResponse<List<Operations>>>> = flow {
        emitAll(homeRepository.getLocalOperation(date))
    }
}
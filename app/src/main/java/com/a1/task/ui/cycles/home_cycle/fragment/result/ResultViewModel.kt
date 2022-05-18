package com.a1.task.ui.cycles.home_cycle.fragment.result

import androidx.lifecycle.viewModelScope
import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations
import com.a1.domain.usecases.GetCurrenciesUseCase
import com.a1.domain.usecases.GetOperationsUseCase
import com.a1.domain.usecases.InsertOperationUseCase
import com.a1.domain.util.DataState
import com.a1.task.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getOperationsUseCase: GetOperationsUseCase
) :
    BaseViewModel() {

    private val _operationsResponse =
        MutableStateFlow<DataState<BaseResponse<List<Operations>>>>(DataState.Idle)
    val operationsResponse: MutableStateFlow<DataState<BaseResponse<List<Operations>>>>
        get() = _operationsResponse

    fun getOperations(date: Long) {
        _operationsResponse.value = DataState.Idle
        viewModelScope.launch {
            getOperationsUseCase(date).collect {
                _operationsResponse.value = it
            }
        }
    }
}
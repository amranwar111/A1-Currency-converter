package com.a1.task.ui.cycles.home_cycle.fragment.home

import androidx.lifecycle.viewModelScope
import com.a1.domain.entities.BaseResponse
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.usecases.GetCurrenciesUseCase
import com.a1.domain.util.DataState
import com.a1.task.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCurrenciesUseCase: GetCurrenciesUseCase
) :
    BaseViewModel() {

    private val _currenciesResponse =
        MutableStateFlow<DataState<BaseResponse<CurrenciesResponse>>>(DataState.Idle)
    val currenciesResponse: MutableStateFlow<DataState<BaseResponse<CurrenciesResponse>>>
        get() = _currenciesResponse


    fun getCurrencies(key: String) {
        _currenciesResponse.value = DataState.Idle
        viewModelScope.launch {
            getCurrenciesUseCase(key).collect {
                _currenciesResponse.value = it
            }
        }
    }
}
package com.a1.task.ui.cycles.home_cycle.fragment.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1.domain.entities.CurrenciesResponse
import com.a1.domain.entities.Operations
import com.a1.domain.entities.SingleCurrencyModel
import com.a1.task.databinding.FragmentResultBinding
import com.a1.task.ui.base.BaseFragment
import com.a1.task.ui.cycles.home_cycle.fragment.result.adapter.LastCurrenciesAdapter
import com.a1.task.ui.cycles.home_cycle.fragment.result.adapter.OperationsAdapter
import com.a1.task.ui.utils.applyCommonSideEffects
import com.a1.utils.common.fromJson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.*

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    override val viewModel by viewModels<ResultViewModel>()

    private lateinit var operationsAdapter: OperationsAdapter
    private lateinit var lastCurrenciesAdapter: LastCurrenciesAdapter

    private lateinit var lastCurrencies: CurrenciesResponse

    override fun afterCreateView() {
        super.afterCreateView()

        lastCurrencies = requireArguments().getString("lastCurrencies")!!.fromJson()

        operationsAdapter = OperationsAdapter()
        lastCurrenciesAdapter = LastCurrenciesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getOperations(getCurrentDate())
        setLastCurrencies()
    }

    private fun setLastCurrencies() {
        val listCurrencies = mutableListOf<SingleCurrencyModel>()
        lastCurrencies.rates?.apply {
            forEach { rate ->
                if (listCurrencies.size == 10)
                    return@apply
                val currencyModel = SingleCurrencyModel(rate.key, rate.value)
                listCurrencies.add(currencyModel)
            }
        }
        lastCurrenciesAdapter.insertData(listCurrencies)
        binding.rvLastCurrencies.adapter = lastCurrenciesAdapter
    }

    private fun getCurrentDate(): Long {
        val calendar: Calendar = Calendar.getInstance()
        return calendar.timeInMillis
    }

    private fun operationsObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.operationsResponse.collect { it ->
                it.applyCommonSideEffects(this@ResultFragment, showSuccessToast = false) {
                    operationsAdapter.insertData(it.data as MutableList<Operations>)
                    binding.rvLastDays.adapter = operationsAdapter
                }
            }
        }
    }

    override fun startObserver() {
        super.startObserver()

        operationsObserver()
    }
}
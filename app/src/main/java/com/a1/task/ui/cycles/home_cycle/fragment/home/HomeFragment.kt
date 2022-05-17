package com.a1.task.ui.cycles.home_cycle.fragment.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1.domain.entities.Operations
import com.a1.domain.entities.SingleCurrencyModel
import com.a1.task.databinding.FragmentHomeBinding
import com.a1.task.ui.base.BaseFragment
import com.a1.task.ui.utils.applyCommonSideEffects
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.*
import kotlin.properties.Delegates

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel by viewModels<HomeViewModel>()

    private var apiKey = "37b4e8e2a6e2df13925e2c40b2111cc0"

    private var selectedAmount by Delegates.notNull<Float>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCurrencies(apiKey)
        getCurrentDate()
    }

    private fun currenciesObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.currenciesResponse.collect { it ->
                it.applyCommonSideEffects(this@HomeFragment, showSuccessToast = false) {
                    setSpinnerAdapter(it.data?.rates!!)
                }
            }
        }
    }

    private fun setSpinnerAdapter(rates: Map<String, String>) {
        val data = setDataModel(rates)
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            data
        )
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spTo.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                selectedAmount = data[p2].amount.toFloat()
                if (binding.etFrom.text!!.isNotEmpty()) {
                    convertAndAddToDB(data[p2])
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.spTo.adapter = arrayAdapter
    }

    private fun convertAndAddToDB(singleCurrency: SingleCurrencyModel) {
        binding.etTo.setText(
            (binding.etFrom.text.toString()
                .toFloat() * selectedAmount).toString()
        )
        insertLocalOperation(
            Operations(
                from = "EUR",
                to = singleCurrency.name,
                fromValue = binding.etFrom.text.toString().toFloat(),
                toValue = binding.etTo.text.toString().toFloat(),
                date = getCurrentDate()
            )
        )
    }

    private fun insertLocalOperation(operations: Operations) {
        viewModel.insertOperation(operations)
    }

    private fun setDataModel(data: Map<String, String>?): MutableList<SingleCurrencyModel> {
        val currencies = mutableListOf<SingleCurrencyModel>()
        data?.forEach { currency ->
            currencies.add(SingleCurrencyModel(currency.key, currency.value))
        }
        return currencies
    }

    private fun getCurrentDate(): Long {
        val calendar: Calendar = Calendar.getInstance()
        return calendar.timeInMillis
    }

    override fun startObserver() {
        super.startObserver()

        currenciesObserver()
    }
}
package com.a1.task.ui.cycles.home_cycle.fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.a1.task.databinding.FragmentHomeBinding
import com.a1.task.ui.base.BaseFragment
import com.a1.task.ui.utils.applyCommonSideEffects
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel by viewModels<HomeViewModel>()

    private var apiKey = "37b4e8e2a6e2df13925e2c40b2111cc0"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCurrencies(apiKey)
    }

    private fun currenciesObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.currenciesResponse.collect {
                it.applyCommonSideEffects(this@HomeFragment, showSuccessToast = false)
            }
        }
    }

    override fun startObserver() {
        super.startObserver()

        currenciesObserver()
    }
}
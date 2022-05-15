package com.aait.sa.ui.cycles.home_cycle.fragment.home

import androidx.fragment.app.viewModels
import com.aait.sa.databinding.FragmentHomeBinding
import com.aait.sa.ui.base.BaseFragment
import com.aait.sa.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel by viewModels<BaseViewModel>()
}
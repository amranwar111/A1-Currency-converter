package com.a1.task.ui.cycles.home_cycle.fragment.home

import androidx.fragment.app.viewModels
import com.a1.task.databinding.FragmentHomeBinding
import com.a1.task.ui.base.BaseFragment
import com.a1.task.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val viewModel by viewModels<BaseViewModel>()
}
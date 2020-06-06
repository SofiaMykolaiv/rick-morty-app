package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
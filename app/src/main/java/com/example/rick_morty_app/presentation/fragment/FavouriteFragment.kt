package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.viewmodel.FavouriteViewModel
import com.example.rick_morty_app.presentation.viewmodel.HomeViewModel
import org.koin.android.ext.android.inject

class FavouriteFragment : BaseFragment<FavouriteViewModel>() {

    override val viewModel by inject<FavouriteViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_favourite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
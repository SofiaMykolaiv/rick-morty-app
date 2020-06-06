package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.viewmodel.SearchViewModel
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment<SearchViewModel>() {

    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}
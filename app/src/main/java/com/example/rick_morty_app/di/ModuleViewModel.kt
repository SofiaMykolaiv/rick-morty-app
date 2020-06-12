package com.example.rick_morty_app.di

import com.example.rick_morty_app.presentation.viewmodel.FavouriteViewModel
import com.example.rick_morty_app.presentation.viewmodel.HomeViewModel
import com.example.rick_morty_app.presentation.viewmodel.SearchViewModel
import com.example.rick_morty_app.presentation.viewmodel.ShowResultViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavouriteViewModel() }
    viewModel { ShowResultViewModel() }
}
package com.example.rick_morty_app.di

import com.example.rick_morty_app.presentation.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavouriteViewModel() }
    viewModel { ShowResultViewModel() }
    viewModel { LocationViewModel() }
    viewModel { EpisodeViewModel() }
    viewModel { CharacterDetailsViewModel() }
}
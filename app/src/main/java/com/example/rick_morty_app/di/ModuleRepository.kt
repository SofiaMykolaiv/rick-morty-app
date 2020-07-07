package com.example.rick_morty_app.di

import com.example.rick_morty_app.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository() }
    single { SearchRepository() }
    single { LocationRepository() }
    single { EpisodeRepository() }
    single { CharacterDetailsRepository() }
    single { FavouriteRepository() }
}
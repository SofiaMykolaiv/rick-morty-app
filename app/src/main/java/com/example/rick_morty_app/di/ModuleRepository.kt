package com.example.rick_morty_app.di

import com.example.rick_morty_app.data.repository.HomeRepository
import com.example.rick_morty_app.data.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository() }
    single { SearchRepository() }
}
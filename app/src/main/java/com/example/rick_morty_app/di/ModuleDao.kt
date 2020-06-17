package com.example.rick_morty_app.di

import com.example.rick_morty_app.data.database.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single { get<AppDatabase>().characterDao() }
}
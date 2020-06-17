package com.example.rick_morty_app.di

import androidx.room.Room
import com.example.rick_morty_app.data.database.AppDatabase
import com.example.rick_morty_app.presentation.RickMortyApplication
import org.koin.dsl.module

private const val DATABASE_NAME = "Rick-and-Morty-Database"

val databaseModule = module {
    single { provideDatabase() }
}

private fun provideDatabase(): AppDatabase =
    Room.databaseBuilder(
        RickMortyApplication.getAppInstance,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()
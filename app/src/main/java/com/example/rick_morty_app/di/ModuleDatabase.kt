package com.example.rick_morty_app.di

import org.koin.dsl.module

private const val DATABASE_NAME = "Rick-and-Morty-Database"

val databaseModule = module {
//    single { provideDatabase() }
}

//private fun provideDatabase(): AppDatabase =
//    Room.databaseBuilder(NewsApplication.getAppInstance, AppDatabase::class.java, DATABASE_NAME)
//        .fallbackToDestructiveMigration()
//        .build()
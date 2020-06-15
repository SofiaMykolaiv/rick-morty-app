package com.example.rick_morty_app.di

import com.example.rick_morty_app.data.network.retrofit.service.CharacterService
import com.example.rick_morty_app.data.network.retrofit.service.LocationService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { get<Retrofit>().create(CharacterService::class.java) }
    single { get<Retrofit>().create(LocationService::class.java) }
}
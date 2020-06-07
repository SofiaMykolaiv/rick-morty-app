package com.example.rick_morty_app.data.network.retrofit.service

import com.example.rick_morty_app.data.network.response.BaseCharacterResponse
import retrofit2.http.GET

interface CharacterService {

    @GET("/api/character/")
    suspend fun loadCharacterList(): BaseCharacterResponse
}
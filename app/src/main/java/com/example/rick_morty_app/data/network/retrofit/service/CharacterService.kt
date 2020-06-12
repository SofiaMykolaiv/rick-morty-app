package com.example.rick_morty_app.data.network.retrofit.service

import com.example.rick_morty_app.data.network.response.BaseCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("/api/character/")
    suspend fun loadBaseCharacterList(): BaseCharacterResponse

    @GET("/api/character/")
    suspend fun filterCharacters(
        @Query("name") name: String,
        @Query("status") status: String,
        @Query("species") species: String,
        @Query("type") type: String,
        @Query("gender") gender: String
    ): BaseCharacterResponse
}
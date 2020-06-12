package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.network.response.BaseCharacterResponse
import com.example.rick_morty_app.data.network.retrofit.service.CharacterService
import org.koin.core.inject

class SearchRepository : BaseRepository {

    private val characterService by inject<CharacterService>()

    suspend fun filterCharacters(
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ): BaseCharacterResponse {
        val baseCharacterResponse = characterService.filterCharacters(
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender
        )
        return baseCharacterResponse
    }
}
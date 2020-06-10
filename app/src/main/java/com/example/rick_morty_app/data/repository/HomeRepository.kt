package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.network.response.BaseCharacterResponse
import com.example.rick_morty_app.data.network.retrofit.service.CharacterService
import org.koin.core.inject

class HomeRepository : BaseRepository {

    private val characterService by inject<CharacterService>()

    suspend fun loadCharacterListNetwork(): BaseCharacterResponse {
        val baseCharacterResponse = characterService.loadBaseCharacterList()
        return baseCharacterResponse
    }
}
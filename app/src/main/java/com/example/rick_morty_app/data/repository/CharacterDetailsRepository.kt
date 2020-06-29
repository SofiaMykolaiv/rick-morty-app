package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.network.response.CharacterResponse
import com.example.rick_morty_app.data.network.retrofit.service.CharacterService
import org.koin.core.inject

class CharacterDetailsRepository : BaseRepository {

    private val characterService by inject<CharacterService>()

    suspend fun loadCharacterDetailsNetwork(id: Int): CharacterResponse {
        val characterResponse = characterService.loadSingleCharacter(id = id)
        return characterResponse
    }
}
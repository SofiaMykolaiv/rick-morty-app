package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.database.dao.CharacterDao
import com.example.rick_morty_app.data.database.entity.CharacterEntity
import com.example.rick_morty_app.data.mapper.mapResponseToEntity
import com.example.rick_morty_app.data.network.response.BaseCharacterResponse
import com.example.rick_morty_app.data.network.retrofit.service.CharacterService
import com.example.rick_morty_app.presentation.model.CharacterModel
import org.koin.core.inject

class HomeRepository : BaseRepository {

    private val characterService by inject<CharacterService>()
    private val characterDao by inject<CharacterDao>()

    suspend fun loadCharacterListNetwork(): BaseCharacterResponse {
        val baseCharacterResponse = characterService.loadBaseCharacterList()
        characterDao.insert(mapResponseToEntity(baseCharacterResponse.characterListResponse))
        return baseCharacterResponse
    }

    suspend fun loadCharacterListDatabase(): List<CharacterEntity> {
        val characterList = characterDao.getList()
        return characterList
    }

    suspend fun setIsFavourite(characterModel: CharacterModel): List<CharacterEntity> {
        val characterEntity = characterDao.getCharacterById(characterModel.id!!)
        return if (characterEntity.isFavourite == true) {
            characterEntity.isFavourite = false
            characterDao.insert(characterEntity)
            characterDao.getList()
        } else {
            characterEntity.isFavourite = true
            characterDao.insert(characterEntity)
            characterDao.getList()
        }
    }
}
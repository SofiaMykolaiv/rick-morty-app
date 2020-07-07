package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.database.dao.CharacterDao
import com.example.rick_morty_app.data.database.entity.CharacterEntity
import com.example.rick_morty_app.presentation.model.CharacterModel
import org.koin.core.inject

class FavouriteRepository : BaseRepository {

    private val characterDao by inject<CharacterDao>()

    suspend fun loadFavouriteListDatabase(): List<CharacterEntity> {
        val favouriteList = characterDao.getFavouriteList(isFavourite = true)
        return favouriteList
    }

    suspend fun deleteFavouriteDatabase(characterModel: CharacterModel) {
        val characterEntity = characterDao.getCharacterById(characterModel.id!!)
        characterEntity.isFavourite = false
        characterDao.insert(characterEntity)
    }
}
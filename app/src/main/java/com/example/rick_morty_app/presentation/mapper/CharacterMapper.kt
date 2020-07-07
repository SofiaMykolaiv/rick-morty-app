package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.database.entity.CharacterEntity
import com.example.rick_morty_app.data.network.response.CharacterResponse
import com.example.rick_morty_app.presentation.model.CharacterModel

fun mapResponseToModel(characterResponseList: List<CharacterResponse>) =
    characterResponseList.map { characterResponse ->
        CharacterModel(
            id = characterResponse.id,
            name = characterResponse.name,
            status = characterResponse.status,
            species = characterResponse.species,
            type = characterResponse.type,
            gender = characterResponse.gender,
            origin = mapResponseToModel(characterResponse.origin!!),
            location = mapResponseToModel(characterResponse.location),
            imageUrl = characterResponse.imageUrl,
            created = characterResponse.created
        )
    }

fun mapResponseToModel(characterResponse: CharacterResponse) =
    CharacterModel(
        id = characterResponse.id,
        name = characterResponse.name,
        status = characterResponse.status,
        species = characterResponse.species,
        type = characterResponse.type,
        gender = characterResponse.gender,
        origin = mapResponseToModel(characterResponse.origin!!),
        location = mapResponseToModel(characterResponse.location),
        imageUrl = characterResponse.imageUrl,
        created = characterResponse.created
    )

fun mapEntityToModel(characterEntityList: List<CharacterEntity>) =
    characterEntityList.map { characterEntity ->
        CharacterModel(
            id = characterEntity.id,
            name = characterEntity.name,
            status = characterEntity.status,
            species = characterEntity.species,
            type = characterEntity.type,
            gender = characterEntity.gender,
            imageUrl = characterEntity.imageUrl,
            created = characterEntity.created,
            isFavourite = characterEntity.isFavourite
        )
    }

fun mapEntityToModel(characterEntity: CharacterEntity) =
    CharacterModel(
        id = characterEntity.id,
        name = characterEntity.name,
        status = characterEntity.status,
        species = characterEntity.species,
        type = characterEntity.type,
        gender = characterEntity.gender,
        imageUrl = characterEntity.imageUrl,
        created = characterEntity.created,
        isFavourite = characterEntity.isFavourite
    )
package com.example.rick_morty_app.data.mapper

import com.example.rick_morty_app.data.database.entity.CharacterEntity
import com.example.rick_morty_app.data.network.response.CharacterResponse

fun mapResponseToEntity(characterList: List<CharacterResponse>) =
    characterList.map { characterResponse ->
        CharacterEntity(
            id = characterResponse.id,
            name = characterResponse.name,
            status = characterResponse.status,
            species = characterResponse.species,
            type = characterResponse.type,
            gender = characterResponse.gender,
            imageUrl = characterResponse.imageUrl,
            created = characterResponse.created
        )
    }
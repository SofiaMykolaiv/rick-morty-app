package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.CharacterResponse
import com.example.rick_morty_app.presentation.model.CharacterModel

fun mapResponseToModel(characterList: List<CharacterResponse>) =
    characterList.map { characterResponse ->
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
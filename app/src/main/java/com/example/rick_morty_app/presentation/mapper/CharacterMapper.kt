package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.CharacterResponse
import com.example.rick_morty_app.data.network.response.LocationResponse
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

//fun mapResponseToModel(characterResponseList: List<CharacterResponse>): List<CharacterModel> {
//    val characterModelList = arrayListOf<CharacterModel>()
//
//    for (characterResponse in characterResponseList) {
//        characterModelList.add(
//            CharacterModel(
//                id = characterResponse.id,
//                name = characterResponse.name,
//                status = characterResponse.status,
//                species = characterResponse.species,
//                type = characterResponse.type,
//                gender = characterResponse.gender,
//                origin = mapResponseToModel(characterResponse.origin!!),
//                location = mapResponseToModel(characterResponse.location),
//                imageUrl = characterResponse.imageUrl,
//                created = characterResponse.created
//            )
//        )
//    }
//
//    return characterModelList
//}

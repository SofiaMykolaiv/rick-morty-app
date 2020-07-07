package com.example.rick_morty_app.presentation.listener

import com.example.rick_morty_app.presentation.model.CharacterModel

interface CharacterClickListener {
    fun onItemClick(characterModel: CharacterModel)
    fun onFavouriteClick(characterModel: CharacterModel)
}
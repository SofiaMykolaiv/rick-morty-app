package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class BaseCharacterResponse(
    @SerializedName("info") var infoResponse: InfoResponse = InfoResponse(),
    @SerializedName("results") var characterListResponse: List<CharacterResponse> = arrayListOf()
)
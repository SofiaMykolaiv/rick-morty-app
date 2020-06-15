package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class BaseLocationResponse(
    @SerializedName("info") var infoResponse: InfoResponse = InfoResponse(),
    @SerializedName("results") var locationResponse: List<LocationResponse> = arrayListOf()
)
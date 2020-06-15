package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class BaseEpisodeResponse(
    @SerializedName("info") var infoResponse: InfoResponse = InfoResponse(),
    @SerializedName("results") var episodeResponse: List<EpisodeResponse> = arrayListOf()
)
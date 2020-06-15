package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class EpisodeResponse (
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("air_date") var airDate: String? = "",
    @SerializedName("episode") var episode: String? = "",
    @SerializedName("characters") var characters: List<String>? = arrayListOf(),
    @SerializedName("url") var url: String? = "",
    @SerializedName("created") var created: String? = ""
)
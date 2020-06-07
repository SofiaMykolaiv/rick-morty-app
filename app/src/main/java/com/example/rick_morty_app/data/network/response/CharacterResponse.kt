package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("status") var status: String? = "",
    @SerializedName("species") var species: String? = "",
    @SerializedName("type") var type: String? = "",
    @SerializedName("gender") var gender: String? = "",
    @SerializedName("origin") var origin: OriginResponse? = OriginResponse(),
    @SerializedName("location") var location: LocationResponse = LocationResponse(),
    @SerializedName("image") var imageUrl: String? = "",
    @SerializedName("episode") var episodeList: List<String>? = arrayListOf(),
    @SerializedName("created") var created: String? = ""
)
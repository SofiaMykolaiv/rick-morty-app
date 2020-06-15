package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class LocationResponse (
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("type") var type: String? = "",
    @SerializedName("dimension") var dimension: String? = "",
    @SerializedName("residents") var residents: List<String>? = arrayListOf(),
    @SerializedName("url") var url: String? = "",
    @SerializedName("created") var created: String? = ""
)
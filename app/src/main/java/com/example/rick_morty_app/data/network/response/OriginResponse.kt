package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class OriginResponse(
    @SerializedName("name") var name: String? = "",
    @SerializedName("url") var url: String? = ""
)
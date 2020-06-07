package com.example.rick_morty_app.data.network.response

import com.google.gson.annotations.SerializedName

data class InfoResponse(
    @SerializedName("count") var count: Int? = 0,
    @SerializedName("pages") var pages: Int? = 0,
    @SerializedName("next") var next: String? = "",
    @SerializedName("prev") var prev: String? = ""
)
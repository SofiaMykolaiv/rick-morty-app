package com.example.rick_morty_app.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeModel(
    var id: Int? = 0,
    var name: String? = "",
    var airDate: String? = "",
    var episode: String? = "",
    var characters: List<String>? = arrayListOf(),
    var url: String? = "",
    var created: String? = ""
) : Parcelable
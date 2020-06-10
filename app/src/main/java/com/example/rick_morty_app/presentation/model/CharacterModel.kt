package com.example.rick_morty_app.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterModel(
    var id: Int? = 0,
    var name: String? = "",
    var status: String? = "",
    var species: String? = "",
    var type: String? = "",
    var gender: String? = "",
    var origin: OriginModel? = OriginModel(),
    var location: LocationModel = LocationModel(),
    var imageUrl: String? = "",
    var episodeList: List<String>? = arrayListOf(),
    var created: String? = ""
) : Parcelable
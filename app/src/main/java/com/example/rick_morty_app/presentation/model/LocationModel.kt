package com.example.rick_morty_app.presentation.model

import android.os.Parcelable
import com.example.rick_morty_app.data.network.response.LocationResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationModel(
    var id: Int? = 0,
    var name: String? = "",
    var type: String? = "",
    var dimension: String? = "",
    var residents: List<String>? = arrayListOf(),
    var url: String? = "",
    var created: String? = ""
) : Parcelable
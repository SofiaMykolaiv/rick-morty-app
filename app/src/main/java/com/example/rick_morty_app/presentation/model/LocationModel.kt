package com.example.rick_morty_app.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationModel(
    var name: String? = "",
    var url: String? = ""
) : Parcelable
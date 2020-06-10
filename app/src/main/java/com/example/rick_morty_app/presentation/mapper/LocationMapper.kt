package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.LocationResponse
import com.example.rick_morty_app.presentation.model.LocationModel

fun mapResponseToModel(locationResponse: LocationResponse) = LocationModel(
    name = locationResponse.name,
    url = locationResponse.url
)
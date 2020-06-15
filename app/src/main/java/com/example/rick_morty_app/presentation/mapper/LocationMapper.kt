package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.LocationResponse
import com.example.rick_morty_app.presentation.model.LocationModel

fun mapResponseToModel(locationResponse: LocationResponse) = LocationModel(
    id = locationResponse.id,
    name = locationResponse.name,
    type = locationResponse.type,
    dimension = locationResponse.dimension,
    residents = locationResponse.residents,
    url = locationResponse.url,
    created = locationResponse.created
)

fun mapResponseToModel(locationResponseList: List<LocationResponse>) =
    locationResponseList.map { locationResponse ->
        LocationModel(
            id = locationResponse.id,
            name = locationResponse.name,
            type = locationResponse.type,
            dimension = locationResponse.dimension,
            residents = locationResponse.residents,
            url = locationResponse.url,
            created = locationResponse.created
        )
    }
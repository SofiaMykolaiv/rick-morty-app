package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.OriginResponse
import com.example.rick_morty_app.presentation.model.OriginModel

fun mapResponseToModel(originResponse: OriginResponse) = OriginModel(
    name = originResponse.name,
    url = originResponse.url
)
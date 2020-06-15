package com.example.rick_morty_app.presentation.mapper

import com.example.rick_morty_app.data.network.response.EpisodeResponse
import com.example.rick_morty_app.presentation.model.EpisodeModel

fun mapResponseToModel(episodeResponseList: List<EpisodeResponse>) =
    episodeResponseList.map { episodeResponse ->
        EpisodeModel(
            id = episodeResponse.id,
            name = episodeResponse.name,
            airDate = episodeResponse.airDate,
            episode = episodeResponse.episode,
            url = episodeResponse.url,
            created = episodeResponse.created
        )
    }
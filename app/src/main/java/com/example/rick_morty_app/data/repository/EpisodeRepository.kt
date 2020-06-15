package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.network.response.BaseEpisodeResponse
import com.example.rick_morty_app.data.network.retrofit.service.EpisodeService
import org.koin.core.inject

class EpisodeRepository : BaseRepository {

    private val episodeService by inject<EpisodeService>()

    suspend fun loadEpisodeListNetwork(): BaseEpisodeResponse {
        val baseEpisodeResponse = episodeService.loadBaseEpisodeList()
        return baseEpisodeResponse
    }
}
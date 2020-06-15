package com.example.rick_morty_app.data.network.retrofit.service

import com.example.rick_morty_app.data.network.response.BaseEpisodeResponse
import retrofit2.http.GET

interface EpisodeService {
    @GET("/api/episode/")
    suspend fun loadBaseEpisodeList(): BaseEpisodeResponse
}
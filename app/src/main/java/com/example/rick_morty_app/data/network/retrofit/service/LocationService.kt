package com.example.rick_morty_app.data.network.retrofit.service

import com.example.rick_morty_app.data.network.response.BaseLocationResponse
import retrofit2.http.GET

interface LocationService {
    @GET("/api/location/")
    suspend fun loadBaseLocationList(): BaseLocationResponse
}
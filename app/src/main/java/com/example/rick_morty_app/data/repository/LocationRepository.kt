package com.example.rick_morty_app.data.repository

import com.example.rick_morty_app.data.network.response.BaseLocationResponse
import com.example.rick_morty_app.data.network.retrofit.service.LocationService
import org.koin.core.inject

class LocationRepository : BaseRepository {

    private val locationService by inject<LocationService>()

    suspend fun loadLocationListNetwork(): BaseLocationResponse {
        val baseLocationResponse = locationService.loadBaseLocationList()
        return baseLocationResponse
    }
}
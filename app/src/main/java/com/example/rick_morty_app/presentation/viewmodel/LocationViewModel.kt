package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.LocationRepository
import com.example.rick_morty_app.presentation.mapper.mapResponseToModel
import com.example.rick_morty_app.presentation.model.LocationModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class LocationViewModel : BaseViewModel() {

    private val locationRepository by inject<LocationRepository>()

    val locationLiveData = MutableLiveData<List<LocationModel>>()

    fun getLocationListNetwork() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val baseLocationResponse = locationRepository.loadLocationListNetwork()
            locationLiveData.postValue(mapResponseToModel(baseLocationResponse.locationResponse))
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}
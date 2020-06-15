package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.EpisodeRepository
import com.example.rick_morty_app.presentation.mapper.mapResponseToModel
import com.example.rick_morty_app.presentation.model.EpisodeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class EpisodeViewModel : BaseViewModel() {
    private val episodeRepository by inject<EpisodeRepository>()

    val episodeLiveData = MutableLiveData<List<EpisodeModel>>()

    fun getEpisodeListNetwork() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val baseEpisodeResponse = episodeRepository.loadEpisodeListNetwork()
            episodeLiveData.postValue(mapResponseToModel(baseEpisodeResponse.episodeResponse))
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}
package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.HomeRepository
import com.example.rick_morty_app.presentation.mapper.mapResponseToModel
import com.example.rick_morty_app.presentation.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel : BaseViewModel() {

    private val homeRepository by inject<HomeRepository>()

    val characterLiveData = MutableLiveData<List<CharacterModel>>()

    fun getCharacterListNetwork() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val baseCharacterResponse = homeRepository.loadCharacterListNetwork()
            characterLiveData.postValue(mapResponseToModel(baseCharacterResponse.characterListResponse))
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}
package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.SearchRepository
import com.example.rick_morty_app.presentation.mapper.mapResponseToModel
import com.example.rick_morty_app.presentation.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class ShowResultViewModel : BaseViewModel() {

    private val searchRepository by inject<SearchRepository>()

    val searchCharacterLiveData = MutableLiveData<List<CharacterModel>>()

    fun getSearchCharacterList(
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ) = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val searchCharacterResponse = searchRepository.filterCharacters(
                name,
                status,
                species,
                type,
                gender
            )
            searchCharacterLiveData.postValue(
                mapResponseToModel(searchCharacterResponse.characterListResponse)
            )
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}
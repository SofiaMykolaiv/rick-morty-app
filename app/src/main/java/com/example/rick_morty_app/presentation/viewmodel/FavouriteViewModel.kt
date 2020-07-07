package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.FavouriteRepository
import com.example.rick_morty_app.presentation.mapper.mapEntityToModel
import com.example.rick_morty_app.presentation.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class FavouriteViewModel : BaseViewModel() {

    private val favouriteRepository by inject<FavouriteRepository>()

    val characterLiveData = MutableLiveData<List<CharacterModel>>()

    fun getFavouriteListDatabase() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val favouriteList = favouriteRepository.loadFavouriteListDatabase()
            characterLiveData.postValue(mapEntityToModel(favouriteList))
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }

    fun deleteFavouriteDatabase(characterModel: CharacterModel) =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                loadingLiveData.postValue(true)
                favouriteRepository.deleteFavouriteDatabase(characterModel)
                val characterList = favouriteRepository.loadFavouriteListDatabase()
                characterLiveData.postValue(mapEntityToModel(characterList))
            } catch (e: Exception) {
                errorMessageLiveData.postValue(e.message)
            } finally {
                loadingLiveData.postValue(false)
            }
        }
}
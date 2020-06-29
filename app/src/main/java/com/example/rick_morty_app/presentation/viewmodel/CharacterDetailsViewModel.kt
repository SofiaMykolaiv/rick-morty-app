package com.example.rick_morty_app.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.rick_morty_app.data.repository.CharacterDetailsRepository
import com.example.rick_morty_app.presentation.mapper.mapResponseToModel
import com.example.rick_morty_app.presentation.model.CharacterModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class CharacterDetailsViewModel : BaseViewModel() {

    private val characterDetailsRepository by inject<CharacterDetailsRepository>()

    val characterDetailsLiveData = MutableLiveData<CharacterModel>()

    fun getCharacterDetailsNetwork(id: Int) = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val characterResponse = characterDetailsRepository.loadCharacterDetailsNetwork(id=id)
            characterDetailsLiveData.postValue(mapResponseToModel(characterResponse))
        }catch (e:Exception){
            errorMessageLiveData.postValue(e.message)
        }finally {
            loadingLiveData.postValue(false)
        }
    }
}
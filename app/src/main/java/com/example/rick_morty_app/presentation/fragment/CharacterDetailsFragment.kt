package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.presentation.viewmodel.BaseViewModel
import com.example.rick_morty_app.presentation.viewmodel.CharacterDetailsViewModel
import com.example.rick_morty_app.utils.loadImageUrl
import com.example.rick_morty_app.utils.showSimpleErrorDialog
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.android.ext.android.inject

class CharacterDetailsFragment : BaseFragment<BaseViewModel>() {

    companion object {
        private const val DEFAULT_ID = -1
    }

    private var characterId = DEFAULT_ID

    override val viewModel by inject<CharacterDetailsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_character_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initArguments()
        loadData()
        observeData()
    }

    private fun initArguments() {
        arguments?.let { arg ->
            characterId = arg.getInt(getString(R.string.arg_id))
        }
    }

    private fun loadData() {
        viewModel.getCharacterDetailsNetwork(id = characterId)
    }

    private fun observeData() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            showSimpleErrorDialog(context, null, exceptionMessage, null, null)
        })
        viewModel.characterDetailsLiveData.observe(viewLifecycleOwner, Observer { characterModel ->
            setCharacterDetailsData(characterModel)
        })
    }

    private fun setCharacterDetailsData(characterModel: CharacterModel) {
        character_image.loadImageUrl(characterModel.imageUrl)
        character_name.text = characterModel.name
        character_status.text = characterModel.status
        character_species.text = characterModel.species
        character_type.text = characterModel.type
        character_gender.text = characterModel.gender
        character_origin.text = characterModel.origin?.name
        character_location_name.text = characterModel.location?.name
        character_location_type.text = characterModel.location?.type
        character_location_dimension.text = characterModel.location?.dimension
        character_created.text = characterModel.created
    }
}
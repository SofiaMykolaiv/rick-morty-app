package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.adapter.CharacterAdapter
import com.example.rick_morty_app.presentation.listener.CharacterClickListener
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.presentation.viewmodel.FavouriteViewModel
import com.example.rick_morty_app.utils.showSimpleErrorDialog
import kotlinx.android.synthetic.main.fragment_favourite.*
import org.koin.android.ext.android.inject

class FavouriteFragment : BaseFragment<FavouriteViewModel>(), CharacterClickListener {

    private lateinit var characterAdapter: CharacterAdapter

    override val viewModel by inject<FavouriteViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_favourite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapter()
        loadData()
        observeData()
    }

    private fun loadData() {
        viewModel.getFavouriteListDatabase()
        swipe_refresh.setOnRefreshListener {
            swipe_refresh.isRefreshing = true
            viewModel.getFavouriteListDatabase()
        }
    }

    private fun observeData() {
        viewModel.characterLiveData.observe(viewLifecycleOwner, Observer { list ->
            characterAdapter.setList(list)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            showSimpleErrorDialog(context, null, exceptionMessage, null, null)
            swipe_refresh.isRefreshing = false
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
            swipe_refresh.isRefreshing = false
        })
    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = characterAdapter
    }

    override fun onItemClick(characterModel: CharacterModel) {
        val arguments = Bundle()
        arguments.putInt(getString(R.string.arg_id), characterModel.id!!)
        navigateSafe(R.id.action_favourite_to_character_details_fragment, arguments)
    }

    override fun onFavouriteClick(characterModel: CharacterModel) {
        viewModel.deleteFavouriteDatabase(characterModel)
    }
}
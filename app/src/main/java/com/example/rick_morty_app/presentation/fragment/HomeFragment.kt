package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.adapter.CharacterAdapter
import com.example.rick_morty_app.presentation.listener.CharacterClickListener
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.presentation.viewmodel.HomeViewModel
import com.example.rick_morty_app.utils.showSimpleErrorDialog
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>(), CharacterClickListener {

    private lateinit var characterAdapter: CharacterAdapter

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapter()
        loadData()
        initObserve()
    }

    private fun loadData() {
        viewModel.getCharacterListNetwork()
        swipe_refresh.setOnRefreshListener {
            swipe_refresh.isRefreshing = true
            viewModel.getCharacterListNetwork()
        }
    }

    private fun initObserve() {
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

    }
}
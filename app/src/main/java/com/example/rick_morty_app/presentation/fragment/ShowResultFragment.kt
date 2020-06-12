package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.adapter.CharacterAdapter
import com.example.rick_morty_app.presentation.listener.CharacterClickListener
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.presentation.viewmodel.SearchViewModel
import com.example.rick_morty_app.presentation.viewmodel.ShowResultViewModel
import com.example.rick_morty_app.utils.showSimpleErrorDialog
import kotlinx.android.synthetic.main.fragment_show_result.*
import org.koin.android.ext.android.inject

class ShowResultFragment : BaseFragment<ShowResultViewModel>(), CharacterClickListener {

    private lateinit var characterAdapter: CharacterAdapter

    private lateinit var name: String
    private lateinit var status : String
    private lateinit var species :String
    private lateinit var type : String
    private lateinit var gender : String

    private val defaultValue = "default_value"

    override val viewModel by inject<ShowResultViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_show_result

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setAdapter()
        initArguments()
        initObserve()
        loadData()
    }

    private fun initArguments() {
        arguments?.let { arg->
            name = arg.getString(getString(R.string.arg_name), defaultValue)
            status = arg.getString(getString(R.string.arg_status), defaultValue)
            species = arg.getString(getString(R.string.arg_species), defaultValue)
            type = arg.getString(getString(R.string.arg_type), defaultValue)
            gender = arg.getString(getString(R.string.arg_gender), defaultValue)
        }
    }

    private fun initObserve() {
        viewModel.searchCharacterLiveData.observe(viewLifecycleOwner, Observer { list ->
            characterAdapter.setList(list)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            showSimpleErrorDialog(context, null, exceptionMessage, null, null)
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
        })
    }

    private fun loadData() {
        viewModel.getSearchCharacterList(name, status, species, type, gender)
    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = characterAdapter
    }

    override fun onItemClick(characterModel: CharacterModel) {

    }
}
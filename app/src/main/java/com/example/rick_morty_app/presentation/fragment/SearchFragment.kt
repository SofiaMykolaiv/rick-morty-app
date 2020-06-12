package com.example.rick_morty_app.presentation.fragment

import android.os.Bundle
import android.widget.Toast
import com.example.rick_morty_app.R
import com.example.rick_morty_app.presentation.viewmodel.SearchViewModel
import com.example.rick_morty_app.utils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment<SearchViewModel>() {
    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes(): Int = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_show_result.setOnClickListener {
            hideKeyboard()

            val name = search_name.text.toString()
            val status = search_status.text.toString()
            val species = search_species.text.toString()
            val type = search_type.text.toString()
            val gender = search_gender.text.toString()

            if (name.isEmpty() && status.isEmpty() && species.isEmpty() && type.isEmpty() && gender.isEmpty()) {
                Toast.makeText(context, "Enter at least one field, please.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val arguments = Bundle()
                arguments.putString(getString(R.string.arg_name), name)
                arguments.putString(getString(R.string.arg_status), status)
                arguments.putString(getString(R.string.arg_species), species)
                arguments.putString(getString(R.string.arg_type), type)
                arguments.putString(getString(R.string.arg_gender), gender)

                navigateSafe(R.id.action_search_to_show_result_fragment, arguments)
            }
        }
    }
}
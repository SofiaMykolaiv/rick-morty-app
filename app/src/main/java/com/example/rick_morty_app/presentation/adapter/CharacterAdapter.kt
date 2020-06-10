package com.example.rick_morty_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty_app.databinding.ListItemCharacterBinding
import com.example.rick_morty_app.presentation.listener.CharacterClickListener
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.utils.loadImageUrlWithLeftRoundedCorners

class CharacterAdapter(listener: CharacterClickListener) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private val characterClickListener = listener
    private var characterList = arrayListOf<CharacterModel>()

    fun setList(list: List<CharacterModel>) {
        characterList.clear()
        characterList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = characterList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characterList[position], characterClickListener)
    }

    class ViewHolder(private val binding: ListItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CharacterModel, listener: CharacterClickListener) {
            binding.model = model
            binding.clickListener = listener
            binding.characterImage.loadImageUrlWithLeftRoundedCorners(model.imageUrl)
        }
    }
}
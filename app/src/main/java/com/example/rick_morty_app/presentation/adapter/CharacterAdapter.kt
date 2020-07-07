package com.example.rick_morty_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_morty_app.R
import com.example.rick_morty_app.databinding.ListItemCharacterBinding
import com.example.rick_morty_app.presentation.listener.CharacterClickListener
import com.example.rick_morty_app.presentation.model.CharacterModel
import com.example.rick_morty_app.utils.loadImageUrlWithLeftRoundedCorners

class CharacterAdapter(listener: CharacterClickListener) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private val characterClickListener = listener
    private var characterList = arrayListOf<CharacterModel>()
    private var characterPosition: Int? = DEFAULT_POSITION
    private var isFavourite: Boolean? = false

    companion object {
        private const val DEFAULT_POSITION = -1
    }

    fun setList(list: List<CharacterModel>) {
        characterList.clear()
        characterList.addAll(list)
        notifyDataSetChanged()
    }

    fun setIsFavourite(characterModel: CharacterModel, isFavourite: Boolean?) {
        this.isFavourite = isFavourite
        notifyItemChanged(getPositionItemById(characterModel.id))
    }

    private fun getPositionItemById(id: Int?): Int {
        var result = DEFAULT_POSITION
        for ((position: Int, characterModel: CharacterModel) in characterList.withIndex()) {
            if (characterModel.id == id) {
                result = position
                break
            }
        }
        characterPosition = result
        return result
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
            if (model.isFavourite == true) {
                binding.icFavourite.setImageDrawable(
                    binding.icFavourite.resources.getDrawable(
                        R.drawable.ic_like,
                        null
                    )
                )
            } else {
                binding.icFavourite.setImageDrawable(
                    binding.icFavourite.resources.getDrawable(
                        R.drawable.ic_dislike,
                        null
                    )
                )
            }
        }
    }
}
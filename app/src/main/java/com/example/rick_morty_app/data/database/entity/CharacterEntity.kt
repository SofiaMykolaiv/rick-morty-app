package com.example.rick_morty_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_CHARACTER")
data class CharacterEntity(
    @PrimaryKey var id: Int? = 0,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "status") var status: String? = "",
    @ColumnInfo(name = "species") var species: String? = "",
    @ColumnInfo(name = "type") var type: String? = "",
    @ColumnInfo(name = "gender") var gender: String? = "",
    @ColumnInfo(name = "image") var imageUrl: String? = "",
    @ColumnInfo(name = "created") var created: String? = "",
    @ColumnInfo(name = "isFavourite") var isFavourite: Boolean? = false
)
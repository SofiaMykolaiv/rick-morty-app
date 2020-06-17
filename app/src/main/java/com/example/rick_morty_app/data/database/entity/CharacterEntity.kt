package com.example.rick_morty_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.rick_morty_app.data.network.response.LocationResponse
import com.example.rick_morty_app.data.network.response.OriginResponse

@Entity(tableName = "TABLE_CHARACTER")
data class CharacterEntity(
    @PrimaryKey var id: Int? = 0,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "status") var status: String? = "",
    @ColumnInfo(name = "species") var species: String? = "",
    @ColumnInfo(name = "type") var type: String? = "",
    @ColumnInfo(name = "gender") var gender: String? = "",
    @ColumnInfo(name = "image") var imageUrl: String? = "",
    @ColumnInfo(name = "created") var created: String? = ""
)
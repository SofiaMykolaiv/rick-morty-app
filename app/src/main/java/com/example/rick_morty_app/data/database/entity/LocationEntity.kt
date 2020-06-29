package com.example.rick_morty_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_LOCATION")
data class LocationEntity(
    @PrimaryKey var id: Int? = 0,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "type") var type: String? = "",
    @ColumnInfo(name = "dimension") var dimension: String? = "",
    @ColumnInfo(name = "url") var url: String? = "",
    @ColumnInfo(name = "created") var created: String? = ""
)
package com.example.rick_morty_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rick_morty_app.data.database.dao.CharacterDao
import com.example.rick_morty_app.data.database.dao.LocationDao
import com.example.rick_morty_app.data.database.entity.CharacterEntity
import com.example.rick_morty_app.data.database.entity.LocationEntity

@Database(
    entities = [
        (CharacterEntity::class),
        (LocationEntity::class)
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}
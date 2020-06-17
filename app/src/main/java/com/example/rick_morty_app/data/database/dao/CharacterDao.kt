package com.example.rick_morty_app.data.database.dao

import androidx.room.*
import com.example.rick_morty_app.data.database.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<CharacterEntity>)

    @Delete
    suspend fun delete(obj: CharacterEntity)

    @Query("DELETE FROM TABLE_CHARACTER")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_CHARACTER")
    suspend fun getList(): List<CharacterEntity>

    @Query("SELECT * FROM TABLE_CHARACTER WHERE name = :name")
    suspend fun getCharacter(name: String): CharacterEntity
}
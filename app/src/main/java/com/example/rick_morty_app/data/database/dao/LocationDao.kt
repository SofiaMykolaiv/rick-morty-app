package com.example.rick_morty_app.data.database.dao

import androidx.room.*
import com.example.rick_morty_app.data.database.entity.LocationEntity

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: LocationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: List<LocationEntity>)

    @Delete
    suspend fun delete(obj: LocationEntity)

    @Query("DELETE FROM TABLE_LOCATION")
    suspend fun deleteAll()

    @Query("SELECT * FROM TABLE_LOCATION")
    suspend fun getList(): List<LocationEntity>

    @Query("SELECT * FROM TABLE_LOCATION WHERE name = :name")
    suspend fun getLocation(name: String): LocationEntity
}
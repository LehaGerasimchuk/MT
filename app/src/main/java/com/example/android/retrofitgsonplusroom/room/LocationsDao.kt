package com.example.android.retrofitgsonplusroom.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.retrofitgsonplusroom.model.Locations
import io.reactivex.Flowable

@Dao
interface LocationsDao {
    @Query("SELECT * FROM Locations")
    fun getAll(): Flowable<List<Locations>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrent(item: Locations)
}
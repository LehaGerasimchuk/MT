package com.example.android.retrofitgsonplusroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.android.retrofitgsonplusroom.model.Locations
//import com.example.android.retrofitgsonplusroom.model.Dogs
import io.reactivex.Flowable

@Dao
interface LocationsDao {
    @Query("SELECT * FROM Locations")
    fun getAll(): Flowable<List<Locations>>

    @Insert
    fun insertCurrent(item: Locations)
}
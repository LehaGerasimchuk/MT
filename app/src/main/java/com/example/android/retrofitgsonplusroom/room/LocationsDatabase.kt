package com.example.android.retrofitgsonplusroom.room

import android.content.Context
import androidx.room.*
import com.example.android.retrofitgsonplusroom.model.Locations


@Database(entities = arrayOf(Locations::class), version = 1)
@TypeConverters(Converters::class)
abstract class LocationsDatabase : RoomDatabase() {
    abstract fun locationsDao(): LocationsDao

    companion object {

        @Volatile private var INSTANCE: LocationsDatabase? = null

        fun getInstance(context: Context): LocationsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                LocationsDatabase::class.java,"database" )
                .build()
    }
}
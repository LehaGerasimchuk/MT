package com.example.android.retrofitgsonplusroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Locations(
        @PrimaryKey
        var idd: Int,

        @SerializedName("id")
        @Expose
        val id: Integer,
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("type")
        @Expose
        val type: String,
        @SerializedName("dimension")
        @Expose
        val dimension: String,
        @SerializedName("residents")
        @Expose
        val residents: List<String>,
        @SerializedName("url")
        @Expose
        val url: String,
        @SerializedName("created")
        @Expose
        val created: String
        )
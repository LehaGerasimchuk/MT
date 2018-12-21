package com.example.android.retrofitgsonplusroom.api

//import com.example.android.retrofitgsonplusroom.model.Dogs
import com.example.android.retrofitgsonplusroom.model.Locations
import io.reactivex.Observable
import retrofit2.http.GET

public interface Api {
    @GET("1")
    fun getId(): Observable<Locations>
}
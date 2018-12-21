package com.example.android.retrofitgsonplusroom

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android.retrofitgsonplusroom.api.Api
import com.example.android.retrofitgsonplusroom.model.Locations
import com.example.android.retrofitgsonplusroom.room.LocationsDatabase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var locationslist: Locations
    lateinit var context: Context
    lateinit var mydb: LocationsDatabase
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = applicationContext
        mydb = LocationsDatabase.getInstance(context)

        //Next Button
        button_next.setOnClickListener {
            counter++
            if (counter >= locationslist.residents.size - 1) {
                counter = 0
            }
            textview.setText(locationslist.residents[counter])
            Toast.makeText(applicationContext, "Next", Toast.LENGTH_LONG).show()
            Single.fromCallable({mydb.locationsDao().insertCurrent(locationslist)}).subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("insertCurrent", "+++");
                }, {
                    Log.i("Error ", "---");
                })
        }

        //Previous Button
        button_previous.setOnClickListener {
            Toast.makeText(applicationContext, "Previous", Toast.LENGTH_LONG).show()
            counter--
            if (counter <= 0) {
                counter = locationslist.residents.size - 1
            }
            textview.setText(locationslist.residents[counter])
            Single.fromCallable({mydb.locationsDao().insertCurrent(locationslist)}).subscribeOn(Schedulers.io())
                .subscribe({
                    Log.i("insertCurrent ", "+++");
                }, {
                    Log.i("Error ", "---");
                })
        }

        //Room Button
        button_room.setOnClickListener {
            Toast.makeText(applicationContext, "Room", Toast.LENGTH_LONG).show()

            mydb.locationsDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d("getAll", "dogs image urls" + it.toString())
                },{
                    Log.d("Error:getAll", "lols")
                })
        }

        textview.setText("Zaglushka")

        //Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/location/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val service = retrofit.create(Api::class.java)
        service.getId()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    locationslist = it
                    textview.setText(locationslist.residents[1].toString())
                    Log.i("StringMessage", it.residents.toString())
                }, {
                    Log.i("Subscribe ", "Error")
                })
    }
}

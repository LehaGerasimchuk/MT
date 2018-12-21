package com.example.android.retrofitgsonplusroom.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/android/retrofitgsonplusroom/room/LocationsDao;", "", "getAll", "Lio/reactivex/Flowable;", "", "Lcom/example/android/retrofitgsonplusroom/model/Locations;", "insertCurrent", "", "item", "app_debug"})
public abstract interface LocationsDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Locations")
    public abstract io.reactivex.Flowable<java.util.List<com.example.android.retrofitgsonplusroom.model.Locations>> getAll();
    
    @androidx.room.Insert()
    public abstract void insertCurrent(@org.jetbrains.annotations.NotNull()
    com.example.android.retrofitgsonplusroom.model.Locations item);
}
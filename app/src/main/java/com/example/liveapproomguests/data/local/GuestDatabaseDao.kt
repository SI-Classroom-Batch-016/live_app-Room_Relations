package com.example.liveapproomguests.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liveapproomguests.data.model.Guest

@Dao
interface GuestDatabaseDao {

    @Query("SELECT * FROM Guest")
    fun getAll() : LiveData<List<Guest>>

    @Query("SELECT * FROM Guest")
    fun getAllWithoutLiveData() : List<Guest>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuest(guest : Guest)

}
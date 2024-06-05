package com.example.liveapproomguests.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.liveapproomguests.data.model.Guest

@Dao
interface GuestDatabaseDao {

    @Query("SELECT * FROM Guest")
    fun getAll() : LiveData<List<Guest>>

    @Query("SELECT * FROM Guest WHERE id=:id")
    fun getGuestById(id: Long) : LiveData<Guest>

    @Update
    suspend fun updateGuest(guest: Guest)

    @Delete
    suspend fun deleteGuest(guest: Guest)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuest(guest : Guest)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuestList(guestList : List<Guest>)

    @Query("SELECT Count(*) FROM Guest")
    suspend fun getGuestCount() : Int


}
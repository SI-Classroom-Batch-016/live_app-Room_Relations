package com.example.liveapproomguests.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.liveapproomguests.data.local.DataSource
import com.example.liveapproomguests.data.local.GuestDatabase
import com.example.liveapproomguests.data.model.Guest

class Repository(val database: GuestDatabase) {

    val guestList : LiveData<List<Guest>> = database.dao.getAll()

    init {
        Log.d("Repository", "Ein neues Repository wurde erstellt")
    }

    suspend fun updateGuest(guest: Guest) = database.dao.updateGuest(guest)
    suspend fun deleteGuest(guest: Guest) = database.dao.deleteGuest(guest)

    //Kurzschreibweise
//    fun getGuestById(id: Long) = database.dao.getGuestById(id)

    //Ausgeschrieben
    fun getGuestById(id:Long) : LiveData<Guest> {
        return database.dao.getGuestById(id)
    }

    suspend fun insertGuest(guest: Guest){
        database.dao.insertGuest(guest)
    }

    suspend fun prePopulateDB() {
        if(database.dao.getGuestCount() == 0) {
            database.dao.insertGuestList(DataSource.startData)
        }
    }

}
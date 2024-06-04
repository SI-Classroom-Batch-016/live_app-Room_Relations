package com.example.liveapproomguests.data

import androidx.lifecycle.LiveData
import com.example.liveapproomguests.data.local.GuestDatabase
import com.example.liveapproomguests.data.model.Guest

class Repository(val database: GuestDatabase) {

    val guestList : LiveData<List<Guest>> = database.dao.getAll()


    suspend fun insertGuest(guest: Guest){

        database.dao.insertGuest(guest)

    }

}
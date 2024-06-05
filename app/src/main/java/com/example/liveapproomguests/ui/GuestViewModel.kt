package com.example.liveapproomguests.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.liveapproomguests.data.Repository
import com.example.liveapproomguests.data.local.getInstance
import com.example.liveapproomguests.data.model.Guest
import kotlinx.coroutines.launch

class GuestViewModel(application: Application) : AndroidViewModel(application) {

    //application ist Context und kann genutzt werden um Datenbank zu laden
    private val database = getInstance(application)
    private val repository = Repository(database)


    val guestList = repository.guestList

    init {
        viewModelScope.launch {
            repository.prePopulateDB()
        }
    }

    fun updateGuest(guest: Guest){
        viewModelScope.launch {
            repository.updateGuest(guest)
        }
    }

    fun deleteGuest(guest: Guest){
        viewModelScope.launch {
            repository.deleteGuest(guest)
        }
    }

    fun getGuestById(id: Long) : LiveData<Guest> {
        return repository.getGuestById(id)
    }


    fun insertGuest(guest : Guest){
        viewModelScope.launch {
            repository.insertGuest(guest)
        }
    }

}
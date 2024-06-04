package com.example.liveapproomguests.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
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

    fun insertGuest(guest : Guest){
        viewModelScope.launch {
            repository.insertGuest(guest)
        }
    }

}
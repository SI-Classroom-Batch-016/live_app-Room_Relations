package com.example.liveapproomguests.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.liveapproomguests.data.Repository
import com.example.liveapproomguests.data.local.getInstance
import com.example.liveapproomguests.data.model.Buch
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //application ist Context und kann genutzt werden um Datenbank zu laden
    private val database = getInstance(application)
    private val repository = Repository(database)


    val buecher = repository.buecher
    val leser = repository.leser

    val leserMitBuchListen = repository.leserMitBuchListen


}
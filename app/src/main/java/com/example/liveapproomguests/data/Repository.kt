package com.example.liveapproomguests.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.liveapproomguests.data.local.GuestDatabase
import com.example.liveapproomguests.data.model.Buch
import com.example.liveapproomguests.data.model.Leser

class Repository(val database: GuestDatabase) {

    val buecher : LiveData<List<Buch>> = database.dao.getAllBooks()
    val leser : LiveData<List<Leser>> = database.dao.getAllLeser()

    val leserMitBuchListen = database.dao.getAllLeserMitBuchListen()

}
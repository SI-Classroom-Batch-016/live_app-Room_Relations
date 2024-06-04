package com.example.liveapproomguests.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.liveapproomguests.data.model.Guest

@Database(entities = [Guest::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {
    abstract val dao: GuestDatabaseDao
}

private lateinit var INSTANCE : GuestDatabase

fun getInstance(context : Context) : GuestDatabase{

    synchronized(GuestDatabase::class.java) {
        if(!::INSTANCE.isInitialized) {
            //Datenbank initialisieren und in INSTANCE Variable speicher
            INSTANCE = Room.databaseBuilder(
                context = context,
                klass = GuestDatabase::class.java,
                name = "guest_database"
            ).build()
        }
        return INSTANCE
    }
}




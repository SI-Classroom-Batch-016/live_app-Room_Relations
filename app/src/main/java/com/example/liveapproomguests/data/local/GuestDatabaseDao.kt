package com.example.liveapproomguests.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.liveapproomguests.data.model.Buch
import com.example.liveapproomguests.data.model.Leser
import com.example.liveapproomguests.data.model.LeserMitBuchListe

@Dao
interface GuestDatabaseDao {

    @Query("SELECT * FROM Buch")
    fun getAllBooks() : LiveData<List<Buch>>

    @Query("SELECT * FROM Leser")
    fun getAllLeser() : LiveData<List<Leser>>

    @Query("SELECT * FROM Leser")
    fun getAllLeserMitBuchListen() : LiveData<List<LeserMitBuchListe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBuchList(buchListe : List<Buch>)

    @Query("SELECT Count(*) FROM Buch")
    suspend fun getBuchCount() : Int


}
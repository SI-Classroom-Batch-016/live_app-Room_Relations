package com.example.liveapproomguests.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Buch(

    @PrimaryKey(autoGenerate = true)
    val buchId: Long = 0,

    val name: String,
)




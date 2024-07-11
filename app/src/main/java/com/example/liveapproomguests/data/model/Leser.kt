package com.example.liveapproomguests.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Leser(

    @PrimaryKey(autoGenerate = true)
    val leserId: Long = 0,

    val name: String,

)
package com.example.liveapproomguests.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Leser::class,
        parentColumns = ["id"],
        childColumns = ["ausleiherId"],
        onDelete = ForeignKey.CASCADE // Optional: defines the action on delete
    )]
)
data class Buch(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val name: String,


    val ausleiherId : Long,
)




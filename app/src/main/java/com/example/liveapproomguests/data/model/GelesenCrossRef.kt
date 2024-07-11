package com.example.liveapproomguests.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


//Die Kombination aus leserId und buchId ist eindeutig und wird deswegen als PrimaryKey benutzt
@Entity()
data class GelesenCrossRef(

    @PrimaryKey(autoGenerate = true)
    val crossRefId : Long = 0,

    val leserId : Long,
    val buchId : Long,


)
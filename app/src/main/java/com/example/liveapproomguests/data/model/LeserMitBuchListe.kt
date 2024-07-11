package com.example.liveapproomguests.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class LeserMitBuchListe (

    @Embedded
    val leser: Leser,

    @Relation(
        parentColumn = "id",
        entityColumn = "ausleiherId",
    )
    val buchListe: List<Buch>


)
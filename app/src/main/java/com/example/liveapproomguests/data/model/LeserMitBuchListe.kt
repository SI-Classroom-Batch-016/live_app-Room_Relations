package com.example.liveapproomguests.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

//Leser mit der Listen an gelesenen Büchern
data class LeserMitBuchListe (

    @Embedded
    val leser: Leser,

    @Relation(
        parentColumn = "leserId",
        entityColumn = "buchId",
        associateBy = Junction(GelesenCrossRef::class),
    )
    val buchListe: List<Buch>
)
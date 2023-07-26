package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.cleanarchitecturenoteapp.ui.theme.BabyBlue
import com.plcoding.cleanarchitecturenoteapp.ui.theme.LightGreen
import com.plcoding.cleanarchitecturenoteapp.ui.theme.RedOrange
import com.plcoding.cleanarchitecturenoteapp.ui.theme.RedPink
import com.plcoding.cleanarchitecturenoteapp.ui.theme.Violet



//step: 1 create all the variable whats we need
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val  id: Int? =null
){
    companion object{
        val notecolors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

}
class InvalidNoteException(message: String): Exception(message)

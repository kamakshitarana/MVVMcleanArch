package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//step : 3 create a repositry bcoz its directly access our data sources either db or api
interface NoteRepostiory {

    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)


}
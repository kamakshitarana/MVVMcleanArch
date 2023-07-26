package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data.repositry

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data.data_source.NotesDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepostiory
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//step:4 create a repo impl and override the methods
class NoteRepositryImpl(
    private val dao: NotesDao
) : NoteRepostiory {

    //ctrl+i to overrride the all fun

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
         dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}
package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

//this is our db
@Database(
    entities = [Note::class],
    version =1
)
abstract class NoteDatabase: RoomDatabase(){

    abstract val notesDao: NotesDao
    companion object{
        const val DATABASE_NAME ="notes_db"
    }

}



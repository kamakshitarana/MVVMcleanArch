package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepostiory
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlin.jvm.Throws

//step:14
class AddNote (
    private val repostiory: NoteRepostiory
        ) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){

            throw  InvalidNoteException("The title of the note can't be empty")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repostiory.insertNote(note)
    }

}
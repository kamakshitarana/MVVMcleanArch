package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepostiory
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

//step 7:
class DeleteNote(private val repostiory: NoteRepostiory) {
    suspend operator fun invoke(note: Note){
        repostiory.deleteNote(note)
    }

}
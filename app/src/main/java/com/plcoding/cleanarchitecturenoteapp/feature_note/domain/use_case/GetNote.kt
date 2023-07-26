package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepostiory
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

class GetNote (
    private val repostiory: NoteRepostiory
        ){
    suspend operator fun invoke(id:Int): Note?{
        return repostiory.getNoteById(id)
    }
}
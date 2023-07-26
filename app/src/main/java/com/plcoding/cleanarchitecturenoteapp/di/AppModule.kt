package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepostiory
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data.repositry.NoteRepositryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.AddNote
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNote
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNotes
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//step:10

@Module  //modules are objects they provide a way to define how to provide dependencies.
@InstallIn(SingletonComponent::class)//annotation indicates that this module will be installed in the SingletonComponent. The SingletonComponent is a Hilt component that corresponds to the entire lifetime of the application.
object AppModule {


    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepostiory {
          return NoteRepositryImpl(db.notesDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repostiory: NoteRepostiory): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repostiory),
            deleteNote = DeleteNote(repostiory),
            addNote = AddNote(repostiory),
            getNote = GetNote(repostiory)
        )
    }
}


/***
 * By using Dagger Hilt and modules like AppModule,
 * you can manage the dependencies of your app in a more
 * organized and maintainable way, making it easier to handle
 * complex dependency graphs and achieve better separation of concerns.
 * **/
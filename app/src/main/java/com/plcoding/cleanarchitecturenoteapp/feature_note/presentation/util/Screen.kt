package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util

sealed class Screen(val route: String){
    object NotesScreen: Screen("notes_Screen")
    object AddEditNotesScreen: Screen("Add_edit_note_screen")
}

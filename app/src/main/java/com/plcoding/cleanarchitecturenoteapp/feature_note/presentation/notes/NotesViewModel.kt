package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNote
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

////step:11 =this class is for like use  case class contain the bussiness login and now viewModel needs to take a result
//of these use cases

@HiltViewModel
class NotesViewModel @Inject constructor(
private val noteUseCases: NoteUseCases
):ViewModel(){

    private val _state = mutableStateOf(NotesStates())
    val state: State<NotesStates> =_state
    private var recentlyDeleteNode: Note? =null
    private var getNotesJob: Job? =null

    init {
        getNotes(NoteOrder .Date(OrderType.Descending))
    }


    fun onEvent(event: NotesEvent){
        when(event){
            is NotesEvent.Order ->{
                if (state.value.noteOrder::class == event.noteOrder::class &&
                       state.value.noteOrder.orderType == event.noteOrder.orderType
                ){ return

                }

                getNotes(event.noteOrder)
            }
            is NotesEvent.DeleteNote ->{
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeleteNode =event.note
                }
            }
            is NotesEvent.RestoreNote ->{
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeleteNode ?: return@launch)
                    recentlyDeleteNode =null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value =state.value.copy(
                    isOrderSectionVisible =  !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder){
        getNotesJob?.cancel()
         getNotesJob = noteUseCases.getNotes(noteOrder)
            .onEach {
                notes ->
                _state.value =state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }

}
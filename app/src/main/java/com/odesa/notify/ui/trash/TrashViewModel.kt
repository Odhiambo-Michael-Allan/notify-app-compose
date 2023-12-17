package com.odesa.notify.ui.trash

import androidx.lifecycle.ViewModel
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.data.model.Note
import com.odesa.notify.ui.GRID_VIEW
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TrashViewModel : ViewModel() {

    private val _uiState = MutableStateFlow( TrashUIState() )
    val uiState: StateFlow<TrashUIState> = _uiState

    init {
        initNotesList()
    }

    private fun initNotesList() {
        _uiState.value = TrashUIState( notes = LocalNotesProvider.allNotes )
    }
}

data class TrashUIState(
    val notes: List<Note> = emptyList(),
    val viewType: Int = GRID_VIEW
)
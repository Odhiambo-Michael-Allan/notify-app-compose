package com.odesa.notify.ui.archive

import androidx.lifecycle.ViewModel
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.data.model.Note
import com.odesa.notify.ui.GRID_VIEW
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ArchiveViewModel : ViewModel() {

    private val _uiState = MutableStateFlow( ArchiveUIState() )
    val uiState: StateFlow<ArchiveUIState> = _uiState

    init {
        initNotesList()
    }

    private fun initNotesList() {
        val notes = LocalNotesProvider.allNotes
        _uiState.value = ArchiveUIState( notes = notes )
    }
}

data class ArchiveUIState(
    val notes: List<Note> = emptyList(),
    val viewType: Int = GRID_VIEW
)
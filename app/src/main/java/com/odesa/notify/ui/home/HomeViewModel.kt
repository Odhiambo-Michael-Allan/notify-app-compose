package com.odesa.notify.ui.home

import androidx.lifecycle.ViewModel
import com.odesa.notify.ui.GRID_VIEW
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.data.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow( HomeUIState() )
    val uiState: StateFlow<HomeUIState> = _uiState

    init {
        initNotesList()
    }

    private fun initNotesList() {
        val notes = LocalNotesProvider.allNotes
        _uiState.value = HomeUIState(
            notes = notes
        )
    }


}


data class HomeUIState(
    val notes: List<Note> = emptyList(),
    val viewType: Int = GRID_VIEW
)

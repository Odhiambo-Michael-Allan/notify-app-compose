package com.odesa.notify.ui.reminder

import androidx.lifecycle.ViewModel
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.data.model.Note
import com.odesa.notify.ui.GRID_VIEW
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReminderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow( ReminderUIState() )
    val uiState: StateFlow<ReminderUIState> = _uiState

    init {
        initReminderList()
    }

    private fun initReminderList() {
        val reminders = LocalNotesProvider.allNotes
        _uiState.value = ReminderUIState(
            reminders = reminders
        )
    }

}

data class ReminderUIState(
    val reminders: List<Note> = emptyList(),
    val selectedReminder: Note? = null,
    val viewType: Int = GRID_VIEW
)
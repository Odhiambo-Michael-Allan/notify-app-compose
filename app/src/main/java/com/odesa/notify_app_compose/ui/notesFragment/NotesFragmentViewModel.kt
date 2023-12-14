package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.odesa.notify_app_compose.data.LocalNotesProvider
import com.odesa.notify_app_compose.data.model.Note

class NotesFragmentViewModel : ViewModel() {
    private val _notes = getNotes().toMutableStateList()
    val notes: List<Note>
        get() = _notes

}

private fun getNotes() = LocalNotesProvider.allNotes

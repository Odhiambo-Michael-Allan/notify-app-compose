package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.odesa.notify_app_compose.data.model.Note

class NotesFragmentViewModel : ViewModel() {
    private val _notes = getNotes().toMutableStateList()
    val notes: List<Note>
        get() = _notes

}

private fun getNotes() = List( 100 ) { index -> Note(
    index,
    "A stateless composable is a composable that doesn't" +
            " own any state, meaning it doesn't hold or" +
            " define or modify new state.",
    "A stateful composable is a composable that owns a piece of state that" +
            " can change over time. In real apps, having a 100% stateless composable " +
            "can be difficult to achieve depending on the composable's responsibilities. " +
            "You should design your composables in a way that they will own as little" +
            " state as possible and allow the state to be hoisted, when it makes sense," +
            " by exposing it in the composable's API." )
}
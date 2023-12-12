package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.odesa.notify_app_compose.data.model.Note

@Composable
fun NotesItemList(
    itemList: List<Note>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy( 8.dp ),
        contentPadding = PaddingValues( 8.dp ),
        modifier = modifier
    ) {
        items( itemList, key = { note -> note.id } ) {note ->
            NoteItem( note.title, note.description )
        }
    }
}
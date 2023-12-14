package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odesa.notify_app_compose.data.LocalNotesProvider
import com.odesa.notify_app_compose.data.model.Note
import com.odesa.notify_app_compose.ui.components.DefaultNoteView
import com.odesa.notify_app_compose.ui.components.SimpleListNoteView
import com.odesa.notify_app_compose.ui.theme.NotifyappcomposeTheme


@Composable
fun NotesGridList(
    itemList: List<Note>,
    modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive( 150.dp ),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy( 8.dp ),
        contentPadding = PaddingValues( 8.dp ),
        content = {
            items( itemList, key = { note -> note.id } ) { note ->
                DefaultNoteView(
                    title = note.title,
                    description = note.description,
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                )
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

//        items( itemList, key = { note -> note.id } ) { note ->
//            NoteItem( title = note.title, description = note.description )
//        }


@Composable
fun NotesList(
    itemList: List<Note>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy( 8.dp ),
        contentPadding = PaddingValues( 8.dp ),
        modifier = modifier
    ) {
        items( itemList, key = { note -> note.id } ) {note ->
            DefaultNoteView( note.title, note.description )
        }
    }
}

@Composable
fun NotesSimpleList(
    itemList: List<Note>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy( 8.dp ),
        contentPadding = PaddingValues( 8.dp ),
        modifier = modifier
    ) {
        items( itemList, key = { note -> note.id } ) {note ->
            SimpleListNoteView( note.title, note.description )
        }
    }
}

@Preview( showBackground = true, showSystemUi = true )
@Composable
fun NotesListPreview() {
    NotifyappcomposeTheme {
        NotesList( itemList = getNotes() )
    }
}

@Preview( showBackground = true, showSystemUi = true )
@Composable
fun NotesGridListPreview() {
    NotifyappcomposeTheme {
        NotesGridList( itemList = getNotes() )
    }
}

private fun getNotes() = LocalNotesProvider.allNotes
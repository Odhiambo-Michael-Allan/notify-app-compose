package com.odesa.notify.ui.reminder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.odesa.notify.R
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.ui.GRID_VIEW
import com.odesa.notify.ui.LIST_VIEW
import com.odesa.notify.ui.components.BottomBar
import com.odesa.notify.ui.components.Fab
import com.odesa.notify.ui.components.NotesGridListView
import com.odesa.notify.ui.components.NotesListView
import com.odesa.notify.ui.components.NotesSimpleListView
import com.odesa.notify.ui.components.ScreenContent
import com.odesa.notify.ui.components.TopBar
import com.odesa.notify.ui.theme.NotifyTheme

@Composable
fun ReminderScreen(
    modifier: Modifier = Modifier,
    uiState: ReminderUIState,
    onNavigationDrawerIconClicked: () -> Unit
) {
    ScreenContent(
        modifier = modifier,
        titleId = R.string.reminder,
        viewType = uiState.viewType,
        notes = uiState.reminders,
        bottomBar = { BottomBar() },
        floatingActionButton = { Fab( onClick = {} ) },
        onNavigationDrawerIconClick = onNavigationDrawerIconClicked,
        onGridMenuItemClick = { /*TODO*/ },
        onListMenuItemClick = { /*TODO*/ },
        onSimpleListMenuItemClick = { /*TODO*/ },
        onSearchMenuItemClick = {}
    )
}

@Preview( showSystemUi = true )
@Composable
fun ReminderScreenPreview() {
    NotifyTheme {
        ReminderScreen(
            uiState = ReminderUIState(
                reminders = LocalNotesProvider.allNotes
            ),
            onNavigationDrawerIconClicked = {}
        )
    }
}
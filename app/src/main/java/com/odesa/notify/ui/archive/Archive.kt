package com.odesa.notify.ui.archive

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.odesa.notify.R
import com.odesa.notify.ui.components.BottomBar
import com.odesa.notify.ui.components.DefaultActions
import com.odesa.notify.ui.components.Fab
import com.odesa.notify.ui.components.ScreenContent

@Composable
fun ArchiveScreen(
    modifier: Modifier = Modifier,
    uiState: ArchiveUIState,
    onNavigationDrawerIconClicked: () -> Unit
) {
    ScreenContent(
        modifier = modifier,
        titleId = R.string.archive,
        viewType = uiState.viewType,
        notes = uiState.notes,
        bottomBar = {},
        floatingActionButton = {},
        onNavigationDrawerIconClick = onNavigationDrawerIconClicked,
        topAppBarActions = {
            DefaultActions(
                onSearchMenuItemClick = { /*TODO*/ },
                onEditMenuItemClick = { /*TODO*/ },
                onSortMenuItemClick = { /*TODO*/ },
                onGridMenuItemClick = { /*TODO*/ },
                onListMenuItemClick = { /*TODO*/ },
                onSimpleListMenuItemClick = {}
            )
        }
    )
}
package com.odesa.notify.ui.trash

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.odesa.notify.R
import com.odesa.notify.ui.components.ScreenContent

@Composable
fun TrashScreen(
    modifier: Modifier = Modifier,
    uiState: TrashUIState,
    onNavigationDrawerIconClicked: () -> Unit
) {
    ScreenContent(
        modifier = modifier,
        titleId = R.string.trash,
        viewType = uiState.viewType,
        notes = uiState.notes,
        bottomBar = {},
        floatingActionButton = {},
        onNavigationDrawerIconClick = onNavigationDrawerIconClicked,
        onGridMenuItemClick = {},
        onListMenuItemClick = {},
        onSimpleListMenuItemClick = {},
        onSearchMenuItemClick = {}
    )
}
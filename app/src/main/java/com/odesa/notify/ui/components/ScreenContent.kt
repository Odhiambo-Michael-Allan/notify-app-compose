package com.odesa.notify.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.odesa.notify.data.model.Note
import com.odesa.notify.ui.GRID_VIEW
import com.odesa.notify.ui.LIST_VIEW

@OptIn( ExperimentalMaterial3Api::class )
@Composable
fun ScreenContent(
    modifier: Modifier = Modifier,
    @StringRes titleId: Int,
    viewType: Int,
    notes: List<Note>,
    bottomBar: @Composable () -> Unit,
    floatingActionButton: @Composable () -> Unit,
    onNavigationDrawerIconClick: () -> Unit,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit,
    onSearchMenuItemClick: () -> Unit
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior( rememberTopAppBarState() )

    Scaffold(
        modifier = modifier.nestedScroll( scrollBehavior.nestedScrollConnection ),
        topBar = {
            TopBar(
                titleId = titleId,
                scrollBehavior = scrollBehavior,
                onNavigationDrawerIconClicked = onNavigationDrawerIconClick,
                onGridMenuItemClick = onGridMenuItemClick,
                onListMenuItemClick = onListMenuItemClick,
                onSimpleListMenuItemClick = onSimpleListMenuItemClick,
                onSearchMenuItemClick = onSearchMenuItemClick
            )
        },
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton
    ) { padding ->
        Box( modifier = modifier.padding( padding ) ) {
            when ( viewType ) {
                GRID_VIEW -> NotesGridListView( itemList = notes )
                LIST_VIEW -> NotesListView( itemList = notes )
                else -> NotesSimpleListView( itemList = notes )
            }
        }

    }

}
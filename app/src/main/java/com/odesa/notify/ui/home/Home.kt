package com.odesa.notify.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.odesa.notify.R
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.ui.components.BottomBar
import com.odesa.notify.ui.components.DefaultActions
import com.odesa.notify.ui.components.Fab
import com.odesa.notify.ui.components.ScreenContent
import com.odesa.notify.ui.theme.NotifyTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUIState,
    onNavigationDrawerIconClicked: () -> Unit
) {
    ScreenContent(
        modifier = modifier,
        titleId = R.string.home,
        viewType = uiState.viewType,
        notes = uiState.notes,
        bottomBar = { BottomBar() },
        floatingActionButton = { Fab( onClick = {} ) },
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
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior( rememberTopAppBarState() )
//
//    Scaffold(
//        modifier = Modifier.nestedScroll( scrollBehavior.nestedScrollConnection ),
//        topBar = { TopBar(
//            titleId = R.string.home,
//            scrollBehavior = scrollBehavior,
//            onNavigationDrawerIconClicked = onNavigationDrawerIconClicked,
//            onGridMenuItemClick = {},
//            onListMenuItemClick = {},
//            onSimpleListMenuItemClick = {},
//            onSearchMenuItemClick = {} )
//        },
//
//        bottomBar = { BottomBar() },
//        floatingActionButton = {
//            LargeFloatingActionButton(
//                onClick = {},
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = stringResource( id = R.string.add )
//                )
//            }
//        }
//
//    ) { padding ->
//        Box( modifier = modifier.padding( padding ) ) {
//            when ( homeUIState.viewType ) {
//                GRID_VIEW -> NotesGridListView( itemList = homeUIState.notes )
//                LIST_VIEW -> NotesListView( itemList = homeUIState.notes )
//                else -> NotesSimpleListView( itemList = homeUIState.notes )
//            }
//        }
//    }
}

@Preview( showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    NotifyTheme {
        HomeScreen(
            uiState = HomeUIState( notes = LocalNotesProvider.allNotes ),
            onNavigationDrawerIconClicked = {}
        )
    }
}
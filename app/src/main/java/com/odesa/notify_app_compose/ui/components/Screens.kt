package com.odesa.notify_app_compose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odesa.notify_app_compose.GRID_VIEW
import com.odesa.notify_app_compose.LIST_VIEW
import com.odesa.notify_app_compose.R
import com.odesa.notify_app_compose.SIMPLE_LIST_VIEW
import com.odesa.notify_app_compose.ui.notesFragment.NotesFragmentViewModel
import com.odesa.notify_app_compose.ui.notesFragment.NotesGridList
import com.odesa.notify_app_compose.ui.notesFragment.NotesList
import com.odesa.notify_app_compose.ui.notesFragment.NotesSimpleList
import com.odesa.notify_app_compose.ui.theme.NotifyappcomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    notesFragmentViewModel: NotesFragmentViewModel = viewModel()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior( rememberTopAppBarState() )
    var viewType by rememberSaveable { mutableIntStateOf( GRID_VIEW ) }

    Scaffold(
        modifier = Modifier.nestedScroll( scrollBehavior.nestedScrollConnection ),
        topBar = { TopBar(
            scrollBehavior = scrollBehavior,
            onGridMenuItemClick = { viewType = GRID_VIEW },
            onListMenuItemClick = { viewType = LIST_VIEW } ) {
            viewType = SIMPLE_LIST_VIEW
        } },

        bottomBar = { BottomBar() },
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource( id = R.string.edit )
                )
            }
        }

    ) { padding ->
        Box( modifier = modifier ) {
            Row (
                Modifier
                    .padding(padding)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                when ( viewType ) {
                    GRID_VIEW -> NotesGridList( itemList = notesFragmentViewModel.notes )
                    LIST_VIEW -> NotesList( itemList = notesFragmentViewModel.notes )
                    else -> NotesSimpleList( itemList = notesFragmentViewModel.notes )
                }
            }
        }
    }
}

@Preview( showSystemUi = true )
@Composable
fun NotesScreenPreview() {
    NotifyappcomposeTheme {
        NotesScreen()
    }
}
package com.odesa.notify_app_compose.ui.notesFragment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.odesa.notify_app_compose.GRID_VIEW
import com.odesa.notify_app_compose.LIST_VIEW
import com.odesa.notify_app_compose.R
import com.odesa.notify_app_compose.SIMPLE_LIST_VIEW
import com.odesa.notify_app_compose.ui.menus.TopAppBarDropDownMenu
import com.odesa.notify_app_compose.ui.menus.ViewDropDownMenu
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
        
        bottomBar = { BottomBar() }
        
    ) { padding ->
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit
) {
    var dropdownMenuExpanded by remember { mutableStateOf( false ) }
    var viewDropdownMenuExpanded by remember { mutableStateOf( false ) }

    fun resetMenuStates() {
        dropdownMenuExpanded = false
        viewDropdownMenuExpanded = false
    }

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton( onClick = { /*TODO*/ } ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton( onClick = { /*TODO*/ } ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
            IconButton( onClick = { dropdownMenuExpanded = true } ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null
                )
            }
            TopAppBarDropDownMenu(
                expanded = dropdownMenuExpanded,
                onDismissRequest = {
                    resetMenuStates()
                },
                onEditMenuItemClick = {
                    dropdownMenuExpanded = false
                },
                onSortMenuItemClick = {
                    dropdownMenuExpanded = false
                }
            ) {
                viewDropdownMenuExpanded = true
            }
            ViewDropDownMenu(
                expanded = viewDropdownMenuExpanded,
                onGridMenuItemClick = {
                    onGridMenuItemClick()
                    resetMenuStates()
                },
                onListMenuItemClick = {
                    onListMenuItemClick()
                    resetMenuStates()
                },
                onSimpleListMenuItemClick = {
                    onSimpleListMenuItemClick()
                    resetMenuStates()
                }
            ) {
                resetMenuStates()
            }
        },
        title = {
            Text( "Notes" )
        },
        scrollBehavior = scrollBehavior
    )
}


@Composable
fun BottomBar() {
    BottomAppBar(
        actions = {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = null
                )
            }
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painter = painterResource( id = R.drawable.ic_mic ),
                    contentDescription = null )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource( id = R.drawable.ic_image ),
                    contentDescription = null
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        }
    )
}


@Preview( showBackground = true, showSystemUi = true )
@Composable
fun NotesScreenPreview() {
    NotifyappcomposeTheme {
        NotesScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview( showBackground = true )
@Composable
fun TopBarPreview() {
    NotifyappcomposeTheme {
        TopBar(
            scrollBehavior = TopAppBarDefaults
                .enterAlwaysScrollBehavior(rememberTopAppBarState()),
            onGridMenuItemClick = {},
            onListMenuItemClick = {} ) {}
    }
}

@Preview( showBackground = true )
@Composable
fun BottomBarPreview() {
    NotifyappcomposeTheme {
        BottomBar()
    }
}


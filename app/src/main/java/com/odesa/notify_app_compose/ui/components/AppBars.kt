package com.odesa.notify_app_compose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.odesa.notify_app_compose.R
import com.odesa.notify_app_compose.ui.theme.NotifyappcomposeTheme


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
            containerColor = MaterialTheme.colorScheme.surface,
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview( showBackground = true )
@Composable
fun TopBarPreview() {
    NotifyappcomposeTheme {
        TopBar(
            scrollBehavior = TopAppBarDefaults
                .enterAlwaysScrollBehavior(rememberTopAppBarState()),
            onGridMenuItemClick = {},
            onListMenuItemClick = {}) {}
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(
        actions = {
            IconButton( onClick = { /*TODO*/ } ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null )
            }
            IconButton( onClick = { /*TODO*/ } ) {
                Icon( imageVector = Icons.Default.Brush, contentDescription = "paint" )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Default.Mic, contentDescription = "microphone" )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Image, contentDescription = "insert_image" )
            }
        }
    )
}

@Preview( showBackground = true )
@Composable
fun BottomBarPreview(){
    NotifyappcomposeTheme {
        BottomBar()
    }
}
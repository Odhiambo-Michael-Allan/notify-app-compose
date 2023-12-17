package com.odesa.notify.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.odesa.notify.R
import com.odesa.notify.ui.theme.NotifyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes titleId: Int,
    scrollBehavior: TopAppBarScrollBehavior,
    actions: @Composable RowScope.() -> Unit,
    onNavigationDrawerIconClick: () -> Unit
) {

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            IconButton( onClick = onNavigationDrawerIconClick ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource( id = R.string.navigation_icon )
                )
            }
        },
        actions = actions,
        title = {
            Text( text = stringResource( id = titleId ) )
        },
        scrollBehavior = scrollBehavior
    )

}

@Composable
fun DefaultActions(
    onSearchMenuItemClick: () -> Unit,
    onEditMenuItemClick: () -> Unit,
    onSortMenuItemClick: () -> Unit,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit
) {
    var dropdownMenuExpanded by remember { mutableStateOf( false ) }
    Row {
        IconButton( onClick = onSearchMenuItemClick ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource( id = R.string.search )
            )
        }
        IconButton( onClick = { dropdownMenuExpanded = true } ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource( id = R.string.more_options )
            )
        }
        DefaultDropdownMenu(
            expanded = dropdownMenuExpanded,
            onDismissRequest = { dropdownMenuExpanded = false },
            onEditMenuItemClick = onEditMenuItemClick,
            onSortMenuItemClick = onSortMenuItemClick,
            onGridMenuItemClick = onGridMenuItemClick,
            onListMenuItemClick = onListMenuItemClick,
            onSimpleListMenuItemClick = onSimpleListMenuItemClick
        )
    }
}

@Composable
fun TrashActions(
    onEditMenuItemClick: () -> Unit,
    onEmptyTrashMenuItemClick: () -> Unit
) {
    var dropdownMenuExpanded by remember { mutableStateOf( false ) }
    Row {
        IconButton( onClick = { dropdownMenuExpanded = true } ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = stringResource( id = R.string.more_options )
            )
        }
        TrashDropdownMenu(
            expanded = dropdownMenuExpanded,
            onDismissRequest = { dropdownMenuExpanded = false },
            onEditMenuItemClick = { dropdownMenuExpanded = false },
            onEmptyTrashMenuItemClick = { dropdownMenuExpanded = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview( showBackground = true )
@Composable
fun TopBarPreview() {
    NotifyTheme {
        TopBar(
            titleId = R.string.home,
            scrollBehavior = TopAppBarDefaults
                .enterAlwaysScrollBehavior(rememberTopAppBarState() ),
            onNavigationDrawerIconClick = {},
            actions = {}
        )
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
    NotifyTheme {
        BottomBar()
    }
}
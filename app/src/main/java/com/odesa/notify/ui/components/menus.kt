package com.odesa.notify.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.ClearAll
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.odesa.notify.R

@Composable
fun DefaultDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onEditMenuItemClick: () -> Unit,
    onSortMenuItemClick: () -> Unit,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit
) {

    var viewDropdownMenuExpanded by remember { mutableStateOf( false ) }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.edit ) ) },
            onClick = onEditMenuItemClick,
            leadingIcon = {
                Icon( imageVector = Icons.Outlined.Edit, contentDescription = null )
            }
        )
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.sort ) ) },
            onClick = onSortMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_sort ),
                    contentDescription = null )
            }
        )
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.view ) ) },
            onClick = { viewDropdownMenuExpanded = true },
            leadingIcon = {
                Icon( painter = painterResource( id = R.drawable.ic_view ),
                    contentDescription = null )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_arrow_right ), contentDescription = null
                )
            }
        )
    }
    ViewDropDownMenu(
        expanded = viewDropdownMenuExpanded,
        onDismissRequest = { viewDropdownMenuExpanded = false },
        onGridMenuItemClick = {
            onGridMenuItemClick()
            viewDropdownMenuExpanded = false
        },
        onListMenuItemClick = {
            onListMenuItemClick()
            viewDropdownMenuExpanded = false
        },
        onSimpleListMenuItemClick = {
            onSimpleListMenuItemClick()
            viewDropdownMenuExpanded = false
        }
    )
}

@Composable
fun ViewDropDownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.grid ) ) },
            onClick = onGridMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_grid_view ),
                    contentDescription = null
                )
            }
        )
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.list ) ) },
            onClick = onListMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_list_view ),
                    contentDescription = null
                )
            }
        )
        DropdownMenuItem(
            text = { Text( text = stringResource( id = R.string.simple_list ) ) },
            onClick = onSimpleListMenuItemClick,
            leadingIcon = {
                Icon(
                    painter = painterResource( R.drawable.ic_simple_list_view ),
                    contentDescription = null
                )
            }
        )
    }
}

@Composable
fun TrashDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onEditMenuItemClick: () -> Unit,
    onEmptyTrashMenuItemClick: () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text( stringResource( id = R.string.edit ) ) },
            onClick = onEditMenuItemClick,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource( id = R.string.edit )
                )
            }
        )
        DropdownMenuItem(
            text = { Text( stringResource( id = R.string.empty_trash ) ) },
            onClick = onEmptyTrashMenuItemClick,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.ClearAll,
                    contentDescription = stringResource( id = R.string.empty_trash )
                )
            }
        )
    }
}
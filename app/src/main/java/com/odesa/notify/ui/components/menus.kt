package com.odesa.notify.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.odesa.notify.R

@Composable
fun TopAppBarDropDownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onEditMenuItemClick: () -> Unit,
    onSortMenuItemClick: () -> Unit,
    onViewMenuItemClick: () -> Unit
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            text = { Text( "Edit" ) },
            onClick = onEditMenuItemClick,
            leadingIcon = {
                Icon( imageVector = Icons.Outlined.Edit, contentDescription = null )
            }
        )
        DropdownMenuItem(
            text = { Text( "Sort" ) },
            onClick = onSortMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_sort ),
                    contentDescription = null )
            }
        )
        DropdownMenuItem(
            text = { Text( "View" ) },
            onClick = onViewMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( id = R.drawable.ic_view ),
                    contentDescription = null )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource( id = R.drawable.ic_arrow_right ),
                    contentDescription = null )
            }
        )
    }
}

@Composable
fun ViewDropDownMenu(
    expanded: Boolean,
    onGridMenuItemClick: () -> Unit,
    onListMenuItemClick: () -> Unit,
    onSimpleListMenuItemClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    DropdownMenu( expanded = expanded, onDismissRequest = onDismissRequest ) {
        DropdownMenuItem(
            text = { Text( "Grid" ) },
            onClick = onGridMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_grid_view ),
                    contentDescription = null
                )
            }
        )
        DropdownMenuItem(
            text = { Text( "List" ) },
            onClick = onListMenuItemClick,
            leadingIcon = {
                Icon( painter = painterResource( R.drawable.ic_list_view ),
                    contentDescription = null
                )
            }
        )
        DropdownMenuItem(
            text = { Text( "Simple List" ) },
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
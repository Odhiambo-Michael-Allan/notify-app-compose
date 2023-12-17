package com.odesa.notify.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.odesa.notify.R

@Composable
fun Fab(
    onClick: () -> Unit
) {
    LargeFloatingActionButton( onClick = onClick ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource( id = R.string.add )
        )
    }
}
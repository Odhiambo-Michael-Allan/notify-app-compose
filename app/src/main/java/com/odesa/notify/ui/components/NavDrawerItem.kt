package com.odesa.notify.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily


@Composable
fun NavDrawerItem(
    modifier: Modifier = Modifier,
    @StringRes labelId: Int,
    selected: Boolean = false,
    onClick: () -> Unit,
    icon: ImageVector,
    @StringRes iconDescriptionId: Int
) {
    NavigationDrawerItem(
        modifier = modifier.padding( NavigationDrawerItemDefaults.ItemPadding ),
        label = { Text(
            text = stringResource( id = labelId ) ,
            fontFamily = FontFamily.Monospace
        ) },
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = stringResource( id = iconDescriptionId ) )
        }
    )
}

package com.odesa.notify.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.ConnectWithoutContact
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.odesa.notify.R
import com.odesa.notify.ui.components.NavDrawerItem
import com.odesa.notify.ui.navigation.Archive
import com.odesa.notify.ui.navigation.Home
import com.odesa.notify.ui.navigation.NotifyDestination
import com.odesa.notify.ui.navigation.NotifyNavHost
import com.odesa.notify.ui.navigation.Reminders
import com.odesa.notify.ui.navigation.Trash
import com.odesa.notify.ui.navigation.navigateSingleTopTo
import com.odesa.notify.ui.navigation.notifyDestinations
import com.odesa.notify.ui.theme.NotifyTheme
import kotlinx.coroutines.launch


@OptIn( ExperimentalMaterial3Api::class )
@Composable
fun NotifyApp() {
    NotifyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen = notifyDestinations.find { it.route == currentDestination?.route } ?: Home

        AppContent(
            navController = navController,
            currentScreen
        )
    }

}

@Composable
fun AppContent(
    navController: NavHostController,
    currentScreen: NotifyDestination
) {

    val drawerState = rememberDrawerState( initialValue = DrawerValue.Closed )
    val scope = rememberCoroutineScope()

    fun openDrawer( open: Boolean ) {
        scope.launch {
            drawerState.apply {
                if ( open ) open() else close()
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width( 300.dp )
            ) {
                Spacer( modifier = Modifier.padding( 16.dp ) )

                NavDrawerItem(
                    labelId = R.string.home,
                    selected = currentScreen.route == Home.route,
                    onClick = {
                        navController.navigateSingleTopTo( Home.route )
                        openDrawer( false )
                    },
                    icon = Icons.Filled.ConnectWithoutContact,
                    iconDescriptionId = R.string.home
                )

                NavDrawerItem(
                    labelId = R.string.reminder,
                    selected = currentScreen.route == Reminders.route,
                    onClick = {
                        navController.navigateSingleTopTo( Reminders.route )
                        openDrawer( false )
                    },
                    icon = Icons.Default.Archive,
                    iconDescriptionId = R.string.reminder
                )

                NavDrawerItem(
                    labelId = R.string.archive,
                    selected = currentScreen.route == Archive.route,
                    onClick = {
                        navController.navigateSingleTopTo( Archive.route )
                        openDrawer( false )
                    },
                    icon = Icons.Default.Archive,
                    iconDescriptionId = R.string.archive
                )

                NavDrawerItem(
                    labelId = R.string.trash,
                    selected = currentScreen.route == Trash.route,
                    onClick = {
                        navController.navigateSingleTopTo( Trash.route )
                        openDrawer( false )
                    },
                    icon = Icons.Default.Delete,
                    iconDescriptionId = R.string.trash
                )

            }
        }
    ) {
        Scaffold() { contentPadding ->
            // Screen content
            NotifyNavHost(
                modifier = Modifier.padding( contentPadding ),
                navController = navController,
                onNavigationDrawerIconClicked = { openDrawer( true ) }
            )
        }
    }
}

@Preview( showSystemUi = true )
@Composable
fun NotifyAppPreview() {
    NotifyApp()
}





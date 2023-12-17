package com.odesa.notify.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.odesa.notify.data.LocalNotesProvider
import com.odesa.notify.ui.archive.ArchiveScreen
import com.odesa.notify.ui.archive.ArchiveUIState
import com.odesa.notify.ui.home.HomeScreen
import com.odesa.notify.ui.home.HomeUIState
import com.odesa.notify.ui.reminder.ReminderScreen
import com.odesa.notify.ui.reminder.ReminderUIState
import com.odesa.notify.ui.trash.TrashScreen
import com.odesa.notify.ui.trash.TrashUIState

@Composable
fun NotifyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onNavigationDrawerIconClicked: () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home.route
    ) {
        composable( route = Home.route ) {
            HomeScreen(
                uiState = HomeUIState( notes = LocalNotesProvider.allNotes ),
                onNavigationDrawerIconClicked = onNavigationDrawerIconClicked
            )
        }

        composable( route = Reminders.route ) {
            ReminderScreen(
                uiState = ReminderUIState( reminders = LocalNotesProvider.allNotes ),
                onNavigationDrawerIconClicked =  onNavigationDrawerIconClicked
            )
        }

        composable( route = Archive.route ) {
            ArchiveScreen(
                uiState = ArchiveUIState( notes = LocalNotesProvider.allNotes ),
                onNavigationDrawerIconClicked = onNavigationDrawerIconClicked
            )
        }

        composable( route = Trash.route ) {
            TrashScreen(
                uiState = TrashUIState( notes = LocalNotesProvider.allNotes ),
                onNavigationDrawerIconClicked = onNavigationDrawerIconClicked
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo( route: String ) =
    this.navigate( route ) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
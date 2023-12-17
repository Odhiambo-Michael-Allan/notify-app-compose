package com.odesa.notify.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Contract for information needed on every Notify navigation destination
 */
interface NotifyDestination {
    val route: String
}

object Home : NotifyDestination {
    override val route = "Home"
}

object Reminders : NotifyDestination {
    override val route = "Reminders"
}

object Archive : NotifyDestination {
    override val route = "Archive"
}

object Trash : NotifyDestination {
    override val route = "Trash"
}

object Search : NotifyDestination {
    override val route = "Search"
}

object AddEdit : NotifyDestination {
    override val route = "Add-Edit"
    private const val noteId = "note-id"
    val arguments = listOf(
        navArgument( noteId ) { type = NavType.LongType }
    )
}

val notifyDestinations = listOf( Home, Reminders, Archive, Trash, Search, AddEdit )

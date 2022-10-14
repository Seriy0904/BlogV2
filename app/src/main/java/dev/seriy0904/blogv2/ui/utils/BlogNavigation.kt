package dev.seriy0904.blogv2.ui.utils

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object BlogDestinations {
    const val HOME_ROUTE = "home"
    const val FAVOURITES_ROUTE = "favourites"
}

class BlogNavigationActions(val navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(BlogDestinations.HOME_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
    val navigateToFavourites: () -> Unit = {
        navController.navigate(BlogDestinations.FAVOURITES_ROUTE){
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

}
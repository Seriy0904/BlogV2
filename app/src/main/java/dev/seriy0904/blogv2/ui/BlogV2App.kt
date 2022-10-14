package dev.seriy0904.blogv2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.seriy0904.blogv2.ui.theme.BlogV2Theme
import dev.seriy0904.blogv2.ui.utils.BlogDestinations
import dev.seriy0904.blogv2.ui.utils.BlogNavGraph
import dev.seriy0904.blogv2.ui.utils.BlogNavigationActions

@Composable
fun BlogApp() {
    BlogV2Theme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            BlogNavigationActions(navController)
        }
        Scaffold(
            topBar = { MainTopBar() },
            bottomBar = { MainBottomBar(navigationActions) }
        ) { scaffoldPadding ->
            Box(Modifier.padding(scaffoldPadding)) {
                BlogNavGraph(navController)
            }
        }
    }
}

@Composable
fun MainTopBar() {
    TopAppBar(
        title = { Text(text = "Blog v2") }
    )
}

@Composable
fun MainBottomBar(navigationActions: BlogNavigationActions) {
    val items = listOf(
        BlogDestinations.HOME_ROUTE,
        BlogDestinations.FAVOURITES_ROUTE
    )
    BottomNavigation {
        val navBackStackEntry by navigationActions.navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            BottomNavigationItem(
                selected = (it == currentRoute),
                onClick = {
                    when (it) {
                        BlogDestinations.HOME_ROUTE -> navigationActions.navigateToHome()
                        BlogDestinations.FAVOURITES_ROUTE -> navigationActions.navigateToFavourites()
                    }
                },
                icon = {
                    when (it) {
                        BlogDestinations.HOME_ROUTE -> Icon(
                            imageVector = Icons.Default.Menu,
                            "Main"
                        )
                        BlogDestinations.FAVOURITES_ROUTE -> Icon(
                            imageVector = Icons.Default.Favorite,
                            "Favourites"
                        )
                    }
                })
        }
    }
}

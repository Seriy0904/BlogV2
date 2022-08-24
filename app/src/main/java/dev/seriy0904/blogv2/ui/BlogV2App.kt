package dev.seriy0904.blogv2.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import dev.seriy0904.blogv2.ui.theme.BlogV2Theme
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
        ) {
            BlogNavGraph(navController)

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
fun MainBottomBar(navController: BlogNavigationActions) {
    BottomNavigation() {
        val selectedIndex = remember { mutableStateOf(0) }
        BottomNavigationItem(
            selected = (selectedIndex.value == 0),
            onClick = { selectedIndex.value = 0; navController.navigateToHome() },
            icon = { Icon(imageVector = Icons.Default.Menu, "Main") })
        BottomNavigationItem(
            selected = (selectedIndex.value == 1),
            onClick = { selectedIndex.value = 1; navController.navigateToFavourites() },
            icon = { Icon(imageVector = Icons.Default.Favorite, "Favourites") })
        BottomNavigationItem(
            selected = (selectedIndex.value == 2),
            onClick = { selectedIndex.value = 2 },
            icon = { Icon(imageVector = Icons.Default.Person, "Profile") })
    }
}

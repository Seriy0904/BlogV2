package dev.seriy0904.blogv2.ui.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.seriy0904.blogv2.ui.createblog.CreateBlog
import dev.seriy0904.blogv2.ui.recommendations.MainRecommendedList

@Composable
fun BlogNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = BlogDestinations.HOME_ROUTE
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(BlogDestinations.HOME_ROUTE){MainRecommendedList()}
        composable(BlogDestinations.CREATE_BLOG_ROUTE){ CreateBlog(navController) }
    }
}
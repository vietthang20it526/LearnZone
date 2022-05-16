package com.vku.learnzone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vku.learnzone.view.*
import com.vku.learnzone.viewmodel.CourseViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val vm = CourseViewModel()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(vm)
        }
        composable(Screen.DetailsScreen.route) {
            DetailsScreen(navController = navController)
        }
        composable(Screen.PopularListScreen.route) {
            PopularListScreen(navController = navController)
        }
    }
}
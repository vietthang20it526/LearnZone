package com.vku.learnzone.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object SignInScreen : Screen("sign_in_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details_screen")
    object PopularListScreen : Screen("popular_list_screen")
}
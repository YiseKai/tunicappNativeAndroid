package com.aplicacion.tunicapp.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object LoginScreen : AppScreens("login_screen")
    object MainSpace : AppScreens("main_space")
}
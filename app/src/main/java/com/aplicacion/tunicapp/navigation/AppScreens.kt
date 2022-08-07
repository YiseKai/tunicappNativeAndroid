package com.aplicacion.tunicapp.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen : AppScreens("splash_screen")
    object LoginScreen : AppScreens("login_screen")
    object UserMainSpace : AppScreens("user_main_space")
    object AdminMainSpace : AppScreens("admin_main_space")
    object Noticias : AppScreens("noticias")
    object Hermanos : AppScreens("hermanos")
    object Salida : AppScreens("salida")
    object Añadir : AppScreens("añadir")
}
package com.aplicacion.tunicapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aplicacion.tunicapp.admin.*
import com.aplicacion.tunicapp.login.LoginScreen
import com.aplicacion.tunicapp.login.SplashScreen
import com.aplicacion.tunicapp.user.UserMainSpace

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = AppScreens.SplashScreen.route
    ) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(AppScreens.UserMainSpace.route) {
            UserMainSpace()
        }
        composable(AppScreens.AdminMainSpace.route) {
            AdminMainSpace(navController)
        }
        composable(AppScreens.Noticias.route) {
            NoticiasScreen()
        }
        composable(AppScreens.Hermanos.route) {
            HermanosScreen()
        }
        composable(AppScreens.Salida.route) {
            SalidaScreen()
        }
        composable(AppScreens.Añadir.route) {
            AñadirNoticia()
        }
    }
}
package com.aplicacion.tunicapp.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aplicacion.tunicapp.R
import com.aplicacion.tunicapp.navigation.AdminNavigation
import com.aplicacion.tunicapp.ui.theme.blueApp

@Composable
fun AdminMainSpace() {
    ComposableBars()
}

@Composable
fun ComposableBars() {
    val navigator = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navigator) },
        content = {
            Box(modifier = Modifier.padding(it)) {
                AdminNavigation(navigator = navigator)
            }
        },
        backgroundColor = Color.White
    )
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.panel_admin), fontSize = 18.sp) },
        backgroundColor = blueApp,
        contentColor = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun BottomNavigationBar(navigator: NavHostController) {
    val items = listOf(
        NavigationItem.Noticias,
        NavigationItem.Hermanos,
        NavigationItem.Salida,
        NavigationItem.Añadir,
    )
    BottomNavigation(backgroundColor = blueApp, contentColor = Color.White) {
        val navBackStackEntry by navigator.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            BottomNavigationItem(
                icon = { Icon(painterResource(id = it.icon), contentDescription = it.title) },
                label = { Text(text = it.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == it.route,
                onClick = {
                    navigator.navigate(it.route) {
                        navigator.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
        }
    }
}

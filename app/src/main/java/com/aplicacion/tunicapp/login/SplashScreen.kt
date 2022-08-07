package com.aplicacion.tunicapp.login

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aplicacion.tunicapp.R
import com.aplicacion.tunicapp.navigation.AppScreens
import com.aplicacion.tunicapp.ui.theme.Shapes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigator: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 0f else 1f,
        animationSpec = tween(durationMillis = 4000)
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navigator.popBackStack()
        navigator.navigate(AppScreens.LoginScreen.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_perdon),
            contentDescription = "logo_splash_screen",
            modifier = Modifier
                .clip(Shapes.medium)
                .height(300.dp)
                .width(300.dp),
            alpha = alpha
        )
    }
}
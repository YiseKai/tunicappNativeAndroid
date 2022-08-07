package com.aplicacion.tunicapp.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.aplicacion.tunicapp.ui.theme.blueApp

@Composable
fun UserMainSpace() {
    TopAppBarScreen()
}

@Composable
fun TopAppBarScreen() {
    Surface()
    {
        Scaffold(
            topBar = ({
                TopAppBar(
                    modifier = Modifier.background(blueApp),
                    title = {
                        Text(
                            text = "Tunicapp",
                            color = Color.White,
                            fontWeight = FontWeight.W700
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    })
            })
        ) { padding ->
            Modifier.padding(padding)
        }
    }
}
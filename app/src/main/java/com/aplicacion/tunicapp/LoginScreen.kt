package com.aplicacion.tunicapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aplicacion.tunicapp.navigation.AppScreens
import com.aplicacion.tunicapp.ui.theme.Shapes

@Composable
fun LoginScreen(navigator: NavHostController) {
    Column(
        Modifier
            .padding(80.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Logo()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UserField()
        PasswordField()
        LoginButton(navigator)
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logo_perdon),
        contentDescription = "logo_splash_screen",
        modifier = Modifier
            .clip(Shapes.medium)
            .height(200.dp)
            .width(200.dp),
    )
}

@Composable
fun UserField() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = text,
        label = { Text(text = "DNI") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "icon_person"
            )
        },
        placeholder = { Text(text = "Introduce tu DNI") },
        onValueChange = { newText ->
            text = newText
        },
    )
}

@Composable
fun PasswordField() {
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var hidden by remember {
        mutableStateOf(true)
    }
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),//2
        singleLine = true,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3
        trailingIcon = {// 4
            IconButton(onClick = { hidden = !hidden }) {
                val vector = painterResource(//5
                    if (hidden) R.drawable.ic_baseline_visibility_24
                    else R.drawable.ic_baseline_visibility_off_24
                )
                val description = if (hidden) "Ocultar contraseña" else "Revelar contraseña" //6
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
}

@Composable
fun LoginButton(navigator: NavHostController) {
    TextButton(
        onClick = { navigator.navigate(AppScreens.MainSpace.route) },
        modifier = Modifier.padding(vertical = 16.dp),
    ) {
        Text(text = "Entrar")
    }
}
package com.aplicacion.tunicapp.login

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aplicacion.tunicapp.R
import com.aplicacion.tunicapp.navigation.AppScreens
import com.aplicacion.tunicapp.ui.theme.Shapes
import com.aplicacion.tunicapp.ui.theme.blueApp

@Composable
fun LoginScreen(navigator: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
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
            .padding(80.dp)
            .clip(Shapes.medium)
            .height(250.dp)
            .width(250.dp),
    )
}

@Composable
fun UserField() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    OutlinedTextField(
        value = text,
        modifier = Modifier.padding(vertical = 12.dp),
        label = { Text(text = stringResource(R.string.dni)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "icon_person"
            )
        },
        placeholder = { Text(text = stringResource(R.string.introduce_DNI)) },
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
        modifier = Modifier.padding(vertical = 12.dp),
        onValueChange = { password = it },
        label = { Text(stringResource(R.string.password)) },
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
                val description = if (hidden) stringResource(R.string.ocultar_password) else stringResource(R.string.mostrar_password) //6
                Icon(painter = vector, contentDescription = description)
            }
        }
    )
}

@Composable
fun LoginButton(navigator: NavHostController) {
    TextButton(
        onClick = { navigator.navigate(AppScreens.AdminMainSpace.route) },
        modifier = Modifier
            .padding(vertical = 48.dp)
            .width(280.dp)
            .height(56.dp),
        colors = ButtonDefaults.textButtonColors(backgroundColor = blueApp)
    ) {
        Text(text = stringResource(R.string.acceder), fontWeight = FontWeight.W700, color = Color.White)
    }
}
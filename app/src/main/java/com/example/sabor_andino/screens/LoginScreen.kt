package com.example.sabor_andino.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLoginSuccess: (String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Sabor Andino", style = MaterialTheme.typography.headlineMedium) // [cite: 5]
        TextField(value = email, onValueChange = { email = it }, label = { Text("Correo") })
        TextField(value = pass, onValueChange = { pass = it }, label = { Text("Clave") })

        Button(onClick = { onLoginSuccess(email) }) {
            Text("Entrar")
        }
    }
}
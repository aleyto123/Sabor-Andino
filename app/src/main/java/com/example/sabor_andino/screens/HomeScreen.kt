package com.example.sabor_andino.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(usuario: String, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Hola, $usuario", style = MaterialTheme.typography.headlineSmall) // [cite: 17]

        Button(onClick = { navController.navigate("menu") }) { Text("Ver Menú") } // [cite: 17]
        Button(onClick = { /* Ir a Pedido */ }) { Text("Mi Pedido") } // [cite: 17]
        Button(onClick = { /* Ir a Perfil */ }) { Text("Mi Perfil") } // [cite: 17]
    }
}
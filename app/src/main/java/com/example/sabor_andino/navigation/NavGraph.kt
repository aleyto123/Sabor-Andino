package com.example.sabor_andino.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabor_andino.screens.*

@Composable
fun SaborAndinoNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login" // Pantalla inicial
    ) {
        // 1. Login
        composable("login") {
            LoginScreen(onLoginSuccess = { nombre ->
                navController.navigate("home/$nombre")
            })
        }

        // 2. Home con argumento de nombre [cite: 17, 24]
        composable("home/{usuario}") { backStackEntry ->
            val usuario = backStackEntry.arguments?.getString("usuario") ?: "Invitado"
            HomeScreen(usuario, navController)
        }

        // 3. Menú [cite: 18]
        composable("menu") {
            MenuScreen(navController)
        }

        // Aquí tu compañero agregará "detalle/{id}" y "perfil" [cite: 20, 21]
    }
}
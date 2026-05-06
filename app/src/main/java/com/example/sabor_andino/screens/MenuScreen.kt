package com.example.sabor_andino.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    // Requisito: Mínimo 6 platos [cite: 26]
    val platos = listOf("Ceviche", "Lomo Saltado", "Ají de Gallina", "Anticuchos", "Picarones", "Chicha")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menú") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás") // Requisito [cite: 25]
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(platos) { plato ->
                ListItem(
                    headlineContent = { Text(plato) },
                    supportingContent = { Text("Sabor tradicional") },
                    trailingContent = { Text("S/ 25.00") }
                )
            }
        }
    }
}
package com.example.sabor_andino.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sabor_andino.data.Dish

private enum class AccountTab(val label: String, val routeValue: String) {
    PERFIL("Mi Perfil", "perfil"),
    PEDIDO("Mi Pedido", "pedido")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileOrderScreen(
    userName: String,
    dishes: List<Dish>,
    cartItems: Map<Int, Int>,
    initialTab: String,
    onBack: () -> Unit,
    onChangeQuantity: (Dish, Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableIntStateOf(if (initialTab == AccountTab.PEDIDO.routeValue) 1 else 0)
    }

    val tabs = AccountTab.entries
    val selectedTab = tabs[selectedTabIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(selectedTab.label) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            PrimaryTabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = { selectedTabIndex = index },
                        text = { Text(tab.label) }
                    )
                }
            }

            when (selectedTab) {
                AccountTab.PERFIL -> ProfileContent(userName = userName)
                AccountTab.PEDIDO -> OrderContent(
                    dishes = dishes,
                    cartItems = cartItems,
                    onChangeQuantity = onChangeQuantity
                )
            }
        }
    }
}

@Composable
private fun ProfileContent(userName: String) {
    Column(modifier = Modifier.padding(20.dp)) {
        Text("Datos del cliente", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(14.dp))
        Text("Nombre: $userName")
        Text("Correo: $userName@saborandino.pe")
        Text("Telefono: 987654321")
        Text("Direccion: Av. Andina 123")
    }
}

@Composable
private fun OrderContent(
    dishes: List<Dish>,
    cartItems: Map<Int, Int>,
    onChangeQuantity: (Dish, Int) -> Unit
) {
    val orderedDishes = dishes.filter { cartItems.containsKey(it.id) }
    val total = orderedDishes.sumOf { dish -> (cartItems[dish.id] ?: 0) * dish.price }

    if (orderedDishes.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Pedido vacio",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text("Tu pedido esta vacio", style = MaterialTheme.typography.titleMedium)
            Text("Agrega platos desde el menu", style = MaterialTheme.typography.bodyMedium)
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(orderedDishes, key = { it.id }) { dish ->
                val quantity = cartItems[dish.id] ?: 0
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(dish.name, fontWeight = FontWeight.SemiBold)
                        Text("S/ %.2f c/u".format(dish.price), style = MaterialTheme.typography.bodySmall)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                TextButton(onClick = { onChangeQuantity(dish, -1) }) { Text("-") }
                                Text(quantity.toString())
                                TextButton(onClick = { onChangeQuantity(dish, +1) }) { Text("+") }
                            }
                            Text("S/ %.2f".format(quantity * dish.price), fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Total: S/ %.2f".format(total),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

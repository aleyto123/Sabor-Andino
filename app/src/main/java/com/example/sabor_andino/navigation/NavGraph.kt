package com.example.sabor_andino.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sabor_andino.data.sampleDishes
import com.example.sabor_andino.screens.DishDetailScreen
import com.example.sabor_andino.screens.HomeScreen
import com.example.sabor_andino.screens.LoginScreen
import com.example.sabor_andino.screens.MenuScreen
import com.example.sabor_andino.screens.ProfileOrderScreen

private object Routes {
    const val LOGIN = "login"
    const val HOME = "home/{usuario}"
    const val MENU = "menu"
    const val DETAIL = "detalle/{dishId}"
    const val PROFILE_ORDER = "perfil_pedido/{tab}"
}

@Composable
fun SaborAndinoNavGraph() {
    val navController = rememberNavController()
    val dishes = remember { sampleDishes }
    val cartItems = remember { mutableStateMapOf<Int, Int>() }

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = { userName ->
                    val encodedUser = Uri.encode(userName)
                    navController.navigate("home/$encodedUser") {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Routes.HOME,
            arguments = listOf(navArgument("usuario") { type = NavType.StringType })
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("usuario") ?: "Cliente"
            HomeScreen(
                userName = userName,
                onOpenMenu = { navController.navigate(Routes.MENU) },
                onOpenOrder = { navController.navigate("perfil_pedido/pedido") },
                onOpenProfile = { navController.navigate("perfil_pedido/perfil") }
            )
        }

        composable(Routes.MENU) {
            MenuScreen(
                dishes = dishes,
                onBack = { navController.popBackStack() },
                onDishClick = { dishId -> navController.navigate("detalle/$dishId") }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("dishId") { type = NavType.IntType })
        ) { backStackEntry ->
            val dishId = backStackEntry.arguments?.getInt("dishId")
            val selectedDish = dishes.firstOrNull { it.id == dishId }

            DishDetailScreen(
                dish = selectedDish,
                onBack = { navController.popBackStack() },
                onAddToOrder = { dish, quantity ->
                    val current = cartItems[dish.id] ?: 0
                    cartItems[dish.id] = current + quantity
                },
                onOpenOrder = { navController.navigate("perfil_pedido/pedido") }
            )
        }

        composable(
            route = Routes.PROFILE_ORDER,
            arguments = listOf(navArgument("tab") { type = NavType.StringType })
        ) { backStackEntry ->
            val tab = backStackEntry.arguments?.getString("tab") ?: "perfil"
            val homeEntry = navController.getBackStackEntry(Routes.HOME)
            val userName = homeEntry.arguments?.getString("usuario") ?: "Cliente"

            ProfileOrderScreen(
                userName = userName,
                dishes = dishes,
                cartItems = cartItems,
                initialTab = tab,
                onBack = { navController.popBackStack() },
                onChangeQuantity = { dish, delta ->
                    val current = cartItems[dish.id] ?: 0
                    val updated = current + delta
                    if (updated <= 0) {
                        cartItems.remove(dish.id)
                    } else {
                        cartItems[dish.id] = updated
                    }
                }
            )
        }
    }
}

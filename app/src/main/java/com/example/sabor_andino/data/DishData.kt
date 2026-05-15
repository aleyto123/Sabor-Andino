package com.example.sabor_andino.data

enum class DishCategory(val label: String) {
    ENTRADAS("Entradas"),
    FONDO("Platos de fondo"),
    POSTRES("Postres"),
    BEBIDAS("Bebidas")
}

data class Dish(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val fullDescription: String,
    val price: Double,
    val category: DishCategory,
    val imageUrl: String,
    val badge: String? = null
)

val sampleDishes = listOf(
    Dish(
        id = 1,
        name = "Causa Limena",
        shortDescription = "Papa amarilla, pollo y palta.",
        fullDescription = "Capa suave de papa amarilla con limon, rellena con pollo deshilachado, mayonesa casera y palta fresca.",
        price = 18.0,
        category = DishCategory.ENTRADAS,
        imageUrl = "https://loremflickr.com/400/400/peruvian,food?lock=11",
        badge = "Mas vendido"
    ),
    Dish(
        id = 2,
        name = "Anticuchos",
        shortDescription = "Brochetas al carbon con aji panca.",
        fullDescription = "Corazon de res marinado en aji panca y especias, servido con papa dorada y choclo.",
        price = 22.0,
        category = DishCategory.ENTRADAS,
        imageUrl = "https://loremflickr.com/400/400/skewer,food?lock=12"
    ),
    Dish(
        id = 3,
        name = "Lomo Saltado",
        shortDescription = "Carne salteada con papas fritas.",
        fullDescription = "Salteado criollo de carne, cebolla, tomate y salsa de soya, acompanado de arroz y papas fritas.",
        price = 32.0,
        category = DishCategory.FONDO,
        imageUrl = "https://loremflickr.com/400/400/beef,food?lock=13",
        badge = "Mas vendido"
    ),
    Dish(
        id = 4,
        name = "Aji de Gallina",
        shortDescription = "Crema de aji amarillo con pollo.",
        fullDescription = "Pollo deshilachado en crema de aji amarillo, queso y pecanas, servido con arroz y huevo cocido.",
        price = 29.0,
        category = DishCategory.FONDO,
        imageUrl = "https://loremflickr.com/400/400/chicken,food?lock=14"
    ),
    Dish(
        id = 5,
        name = "Picarones",
        shortDescription = "Dulce tradicional con miel.",
        fullDescription = "Aros de camote y zapallo fritos al momento, banados en miel de chancaca.",
        price = 16.0,
        category = DishCategory.POSTRES,
        imageUrl = "https://loremflickr.com/400/400/dessert,donut?lock=15"
    ),
    Dish(
        id = 6,
        name = "Suspiro a la Limena",
        shortDescription = "Postre de manjar y merengue.",
        fullDescription = "Copa de manjar blanco con merengue italiano aromatizado con canela y oporto.",
        price = 14.0,
        category = DishCategory.POSTRES,
        imageUrl = "https://loremflickr.com/400/400/dessert,cup?lock=16",
        badge = "Nuevo"
    ),
    Dish(
        id = 7,
        name = "Chicha Morada",
        shortDescription = "Bebida fria de maiz morado.",
        fullDescription = "Refresco natural de maiz morado, pina, canela y clavo.",
        price = 9.0,
        category = DishCategory.BEBIDAS,
        imageUrl = "https://loremflickr.com/400/400/drink,juice?lock=17"
    ),
    Dish(
        id = 8,
        name = "Cafe Pasado",
        shortDescription = "Cafe andino recien filtrado.",
        fullDescription = "Cafe de altura tostado medio, filtrado al instante y servido caliente.",
        price = 8.0,
        category = DishCategory.BEBIDAS,
        imageUrl = "https://loremflickr.com/400/400/coffee,cup?lock=18",
        badge = "Nuevo"
    )
)

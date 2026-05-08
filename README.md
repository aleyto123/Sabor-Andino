# Evaluación 2 de Móviles

**Integrantes:** 
* Mauricio Rojas Tello
* Bellido Chambi Rony Widmer 

## Descripción del Proyecto
"Sabor Andino" es una aplicación móvil desarrollada en Android Studio utilizando Jetpack Compose, enfocada en la gestión de pedidos para un restaurante de comida tradicional peruana.

## Funcionalidades Implementadas

### 1. Sistema de Navegación
Se ha implementado un `NavGraph` centralizado que gestiona las rutas de la aplicación:
* **Ruta "login":** Pantalla de inicio de sesión.
* **Ruta "home/{usuario}":** Pantalla principal que recibe y muestra el nombre del usuario.
* **Ruta "menu":** Lista de platos disponibles.

### 2. Pantallas Desarrolladas
* **LoginScreen:** Permite al usuario ingresar sus credenciales. Al hacer clic en "Entrar", navega hacia la pantalla de inicio enviando el nombre ingresado.
* **HomeScreen:** Saluda al usuario de forma personalizada y ofrece acceso rápido al menú de platos.
* **MenuScreen:** Presenta una lista detallada de platos típicos (Ceviche, Lomo Saltado, Ají de Gallina, etc.). Cumple con el requisito de mostrar al menos 6 opciones con sus respectivos precios y descripciones.

### 3. Mejoras Técnicas y Correcciones
* **Dependencias:** Se configuraron las librerías de `androidx.compose.material:material-icons-extended` para el uso de iconos estándar de navegación.
* **MainActivity:** Se vinculó el punto de entrada de la aplicación con el grafo de navegación.
* **Limpieza de Código:** Se eliminaron errores de sintaxis en las anotaciones de requisitos y se corrigieron referencias de paquetes mal configuradas.

## Requisitos del Sistema
* **Min SDK:** 24
* **Target SDK:** 36
* **Lenguaje:** Kotlin 2.2.10
* **UI Framework:** Jetpack Compose con Material3

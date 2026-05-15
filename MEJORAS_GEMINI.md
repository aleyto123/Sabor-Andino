# MEJORAS_GEMINI.md

## Etapa 2 - Mejora con Gemini en Android Studio

Este archivo documenta la auditoria UI/UX y la implementacion de mejoras sugeridas por Gemini para la app **Sabor Andino**.

## 1) Auditoria UI/UX (Gemini)

### Pantallas auditadas
- Login
- Menu
- Mi Pedido

### Prompt usado en Gemini
"Revisa estas pantallas de Jetpack Compose (Login, Menu y Mi Pedido) y sugiere mejoras concretas de jerarquia visual, transiciones, estados vacios y consistencia de tarjetas en Material 3. Prioriza cambios simples de implementar y de alto impacto visual."

## 2) Mejoras implementadas

### Mejora A: Jerarquia visual y espaciado en Login
- Se rediseno la pantalla de login con mejor estructura visual (titulo, subtitulo, tarjeta contenedora, espaciado y elevacion).
- Se mantiene validacion de correo y contrasena.

**Archivo:** `app/src/main/java/com/example/sabor_andino/screens/LoginScreen.kt`

### Mejora B: Tarjetas de Menu con indicador visual
- Se agrego un indicador de estado en platos (`Nuevo` / `Mas vendido`).
- Se mejoro elevacion y consistencia visual de las tarjetas del menu.

**Archivos:**
- `app/src/main/java/com/example/sabor_andino/data/DishData.kt`
- `app/src/main/java/com/example/sabor_andino/screens/MenuScreen.kt`

### Mejora C: Estado vacio mejorado en Mi Pedido
- Se implemento un estado vacio mas claro con icono y mensaje reforzado.
- Se mejoro elevacion de tarjetas en la lista de pedido.

**Archivo:** `app/src/main/java/com/example/sabor_andino/screens/ProfileOrderScreen.kt`

### Mejora D: Animaciones de transicion entre pantallas
- Se agregaron transiciones suaves (fade + slide) en la navegacion entre pantallas con Navigation Compose.

**Archivo:** `app/src/main/java/com/example/sabor_andino/navigation/NavGraph.kt`

## 3) Capturas de antes y despues

Adjuntar capturas en esta carpeta o en `docs/screenshots/` con estos nombres sugeridos:

- `antes_login.png`
- `despues_login.png`
- `antes_menu.png`
- `despues_menu.png`
- `antes_pedido_vacio.png`
- `despues_pedido_vacio.png`

## 4) Reflexion breve

Las sugerencias fueron utiles porque mejoraron claridad visual y experiencia de uso sin cambiar la logica principal. Se ajustaron algunos detalles para mantener consistencia con la navegacion y el flujo del pedido.

package com.example.sabor_andino.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AndinoGoldDark,
    secondary = AndinoClayDark,
    tertiary = AndinoLeafDark,
    background = AndinoNight,
    surface = AndinoSand,
    onPrimary = AndinoNight,
    onBackground = AndinoCream,
    onSurface = AndinoCream
)

private val LightColorScheme = lightColorScheme(
    primary = AndinoClay,
    secondary = AndinoGold,
    tertiary = AndinoLeaf,
    background = AndinoCream,
    surface = Color.White,
    onPrimary = AndinoCream,
    onBackground = AndinoCoffee,
    onSurface = AndinoCoffee
)

@Composable
fun SaborAndinoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

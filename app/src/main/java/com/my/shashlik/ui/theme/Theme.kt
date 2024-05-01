package com.my.shashlik.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = DarkButton,
    primaryVariant = DarkButton,
    secondary = DarkButton
)

private val LightColorPalette = lightColors(
    primary = DarkButton,
    primaryVariant = DarkButton,
    secondary = DarkButton
)

@Composable
fun ShashlickComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette
    else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}
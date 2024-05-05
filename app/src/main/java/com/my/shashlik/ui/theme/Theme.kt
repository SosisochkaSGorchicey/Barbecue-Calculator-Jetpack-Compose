package com.my.shashlik.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    background = BackgroundColor,
    onBackground = Color.White,
    surfaceVariant = Color.White,
    onSurfaceVariant = CardTextColor,
    onSecondary = CardTextColorHint
)

private val LightColorPalette = lightColorScheme(
    background = BackgroundColor,
    onBackground = Color.White,
    surfaceVariant = Color.White,
    onSurfaceVariant = CardTextColor,
    onSecondary = CardTextColorHint
)

@Composable
fun ShashlickComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette
    else LightColorPalette

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
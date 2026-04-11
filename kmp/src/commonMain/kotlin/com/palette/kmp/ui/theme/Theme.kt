package com.palette.kmp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = darkBlue,
    secondary = darkBlueGrey,
    tertiary = darkLightGrey
)

val LightColorScheme = lightColorScheme(
    primary = blue,
    secondary = blueGrey,
    tertiary = lightGrey
)

@Composable
fun PaletteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme

    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
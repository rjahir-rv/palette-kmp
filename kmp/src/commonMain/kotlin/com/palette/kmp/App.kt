package com.palette.kmp

import androidx.compose.runtime.Composable
import com.palette.kmp.navigation.NavManager
import com.palette.kmp.ui.theme.PaletteTheme

@Composable
fun App() {
    PaletteTheme {
        NavManager()
    }
}




package com.palette.kmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.palette.kmp.screens.ColorPreviewScreen
import com.palette.kmp.screens.HomeScreen
import com.palette.kmp.screens.PaletteScreen

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController = navController)
        }

        composable<Palette> { item ->
            val palette = item.toRoute<Palette>()
            PaletteScreen(navController = navController, id = palette.id, name = palette.name)
        }

        composable<ColorPreview> { item ->
            val preview = item.toRoute<ColorPreview>()
            ColorPreviewScreen(navController = navController, id = preview.id, name = preview.name)
        }
    }
}

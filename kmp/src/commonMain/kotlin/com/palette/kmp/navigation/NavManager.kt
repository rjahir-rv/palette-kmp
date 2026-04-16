package com.palette.kmp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.palette.kmp.screens.HomeScreen
import com.palette.kmp.screens.PaletteScreen

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController = navController)
        }

        composable<Palette> {
            PaletteScreen(navController = navController)
        }
    }
}
package com.thesaifhusain.safeer.domain.navigaion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thesaifhusain.safeer.presentation.*
import com.thesaifhusain.safeer.presentation.ConsoleScreens.AddMasjid

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("welcome") { WelcomeScreen() }
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen() }
        composable("admin") { AdminScreen(navController) }
        composable("console") { ConsoleScreen(navController) }
        composable("masjid") { AddMasjid() }
    }
}
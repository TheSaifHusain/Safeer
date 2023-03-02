package com.thesaifhusain.safeer.domain.navigaion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thesaifhusain.safeer.domain.myViewModel
import com.thesaifhusain.safeer.presentation.*
import com.thesaifhusain.safeer.presentation.ConsoleScreens.AddMasjid

@Composable
fun Navigation(viewModel: myViewModel ) {

    val navController= rememberNavController()
    NavHost(
        navController = navController!!,
        startDestination = "home"
    ) {
        composable("welcome") { WelcomeScreen() }
        composable("home") { HomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen() }
        composable("admin") { AdminScreen(navController) }
        composable("console") { ConsoleScreen(navController) }
        composable("masjid") { AddMasjid(null) }
    }
}
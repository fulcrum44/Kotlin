package org.izv.jcl.agenda.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Navigation(innerPadding)
    }
}

@Composable
fun Navigation(innerPadding: PaddingValues) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(navController, innerPadding)
        }
        composable("add_contact") {
            AddContact(navController, innerPadding)
        }
        composable("edit_contact") {
            EditContact(navController, innerPadding)
        }
    }
}
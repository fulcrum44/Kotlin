package org.izv.jcl.sourcecodeloader.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.izv.jcl.sourcecodeloader.model.repository.SourceCodeRepository
import org.izv.jcl.sourcecodeloader.ui.viewmodel.SourceCodeViewModel

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Navigation(innerPadding)
    }
}

@Composable
fun Navigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    val repository = SourceCodeRepository()
    val viewModel: SourceCodeViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T: ViewModel> create(modelClass: Class<T>): T {
                return SourceCodeViewModel(repository) as T
            }
        }
    )

    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(viewModel, innerPadding)
        }
    }
}
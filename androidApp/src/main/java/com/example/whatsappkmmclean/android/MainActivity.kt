package com.example.whatsappkmmclean.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsappkmmclean.Greeting
import com.example.whatsappkmmclean.android.presentation.ui.BottomNavigationBar
import com.example.whatsappkmmclean.android.presentation.ui.HomeScreen
import com.example.whatsappkmmclean.android.presentation.ui.Screen
import com.example.whatsappkmmclean.android.presentation.ui.SettingsScreen
import com.example.whatsappkmmclean.android.presentation.ui.StatusScreen
import com.example.whatsappkmmclean.android.presentation.ui.UpdatesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Preview
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Status.route) { StatusScreen() }
            composable(Screen.Updates.route) { UpdatesScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}


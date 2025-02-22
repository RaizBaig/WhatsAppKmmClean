package com.example.whatsappkmmclean.android.presentation.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Status,
        Screen.Updates,
        Screen.Settings
    )

    NavigationBar {
        val currentRoute = navController.currentDestination?.route
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        imageVector = when (screen) {
                            is Screen.Home -> Icons.Default.Home
                            is Screen.Status -> Icons.Default.Person
                            is Screen.Updates -> Icons.Default.Notifications
                            is Screen.Settings -> Icons.Default.Settings
                        },
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route) }
            )
        }
    }
}

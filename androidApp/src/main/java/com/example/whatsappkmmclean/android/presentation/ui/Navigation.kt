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
fun BottomNavigationBar(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val items = listOf(
        Screen.Chats,
        Screen.Updates,
        Screen.Communities,
        Screen.Calls
    )

    NavigationBar {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = index == selectedIndex,
                onClick = { onTabSelected(index) },
                icon = {
                    Icon(
                        imageVector = when (screen) {
                            is Screen.Chats -> Icons.Default.Home
                            is Screen.Updates -> Icons.Default.Notifications
                            is Screen.Communities -> Icons.Default.Person
                            is Screen.Calls -> Icons.Default.Settings
                        },
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route) }
            )
        }
    }
}


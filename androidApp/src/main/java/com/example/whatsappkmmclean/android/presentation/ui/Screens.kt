package com.example.whatsappkmmclean.android.presentation.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Status : Screen("status")
    object Updates : Screen("updates")
    object Settings : Screen("settings")
}

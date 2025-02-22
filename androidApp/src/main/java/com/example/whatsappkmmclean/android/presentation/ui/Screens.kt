package com.example.whatsappkmmclean.android.presentation.ui

sealed class Screen(val route: String) {
    object Chats : Screen("Chats")
    object Updates : Screen("Updates")
    object Communities : Screen("Communities")
    object Calls : Screen("Calls")
}

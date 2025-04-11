package com.farimarwat.bookapp.presentation.screen

sealed class Screen(val route:String) {
    object HomeScreen: Screen("home")
    object Details: Screen("details/{key}")
}
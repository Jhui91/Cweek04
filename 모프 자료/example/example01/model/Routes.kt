package com.example.week06.example01.model

sealed class Routes(val route: String) {
    object Home : Routes(route = "Home")
    object ScreenA : Routes(route = "A")
    object ScreenB : Routes(route = "B")
    object ScreenC : Routes(route = "C")
}
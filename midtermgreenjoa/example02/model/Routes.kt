package com.example.midtermgreenjoa.example02.model

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Welcome : Routes("Welcome")
    object Register : Routes("Register")
}
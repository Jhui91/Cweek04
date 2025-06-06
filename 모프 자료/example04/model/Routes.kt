package com.example.week06.example04.model


sealed class Routes (val route: String) {
    object Login : Routes("Login")
    object Register : Routes("Register")
    object Welcome : Routes("Welcome")
}
package com.example.midtermgreenjoa.example02.uicomponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.midtermgreenjoa.example02.navGraph.LoginNavGraph

@Composable
fun LoginMainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    LoginNavGraph(navController= navController)
}
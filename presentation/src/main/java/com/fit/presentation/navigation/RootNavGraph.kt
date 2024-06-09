package com.fit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) { authNavGraph(rootNavController = navController) }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
}
package com.fit.presentation.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.auth.WelcomeScreen
import com.fit.presentation.utils.navigatingToScreen
import kotlinx.serialization.Serializable

@Serializable
object WelcomeScreen
@Serializable
object LoginScreen
@Serializable
object VerifyScreen

internal fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(route = LoginScreen, navOptions = navOptions)
}

internal fun NavController.navigateToVerify(navOptions: NavOptions? = null) {
    this.navigate(route = VerifyScreen, navOptions = navOptions)
}

@Composable
fun AuthNavHost(
    authNavHostController: NavHostController = rememberNavController(),
    navigateToPoll: () -> Unit
) {
    NavHost(navController = authNavHostController, startDestination = WelcomeScreen) {
        val onBack: () -> Unit = { authNavHostController.navigateUp() }

        navigatingToScreen<WelcomeScreen> {
            WelcomeScreen()
        }
    }
}
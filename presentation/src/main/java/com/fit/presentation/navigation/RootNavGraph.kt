package com.fit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.auth.navigation.AuthNavHost
import com.fit.presentation.onboarding.navigation.OnboardingNavHost
import com.fit.presentation.onboarding.navigation.SplashScreen
import kotlinx.serialization.Serializable

@Serializable
object Onboarding
@Serializable
object Auth
@Serializable
object Poll

internal fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(route = Auth, navOptions = navOptions)
}

internal fun NavController.navigateToPoll(navOptions: NavOptions? = null) {
    this.navigate(route = Poll, navOptions = navOptions)
}

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Onboarding
    ) {
        composable<Onboarding> {
            OnboardingNavHost { navController.navigateToAuth() }
        }
        composable<Auth> {
            AuthNavHost { navController.navigateToPoll() }
        }
        composable<Poll> {

        }
    }
}


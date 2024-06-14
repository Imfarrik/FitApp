package com.fit.presentation.auth.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.auth.AuthLauncherVM
import com.fit.presentation.auth.LoginLauncherRoute
import com.fit.presentation.auth.VerifyLauncherRoute
import com.fit.presentation.auth.WelcomeLauncherRoute
import com.fit.presentation.navigation.navigateToCoach
import com.fit.presentation.navigation.navigateToMain
import com.fit.presentation.navigation.navigateToPoll
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
    rootNavHostController: NavHostController,
    authNavHostController: NavHostController = rememberNavController(),
) {
    NavHost(navController = authNavHostController, startDestination = WelcomeScreen) {
        val onBack: () -> Unit = { authNavHostController.navigateUp() }
        var authViewModel: AuthLauncherVM? = null
        val getAuthViewModel: (AuthLauncherVM) -> Unit = {
            authViewModel = it
        }

        navigatingToScreen<WelcomeScreen> {
            WelcomeLauncherRoute(
                onBack = onBack,
                navigateToLogin = { authNavHostController.navigateToLogin() }
            ) { rootNavHostController.navigateToCoach() }
        }
        navigatingToScreen<LoginScreen> {
            LoginLauncherRoute(
                onBack = onBack,
                rememberViewModel = getAuthViewModel,
                navigateToVerify = { authNavHostController.navigateToVerify() }
            ) { rootNavHostController.navigateToMain() }
        }
        navigatingToScreen<VerifyScreen> {
            VerifyLauncherRoute(
                onBack = onBack,
                navigateToPoll = { rootNavHostController.navigateToPoll() }
            ) {
                authViewModel?.verify(it)
            }
        }
    }
}
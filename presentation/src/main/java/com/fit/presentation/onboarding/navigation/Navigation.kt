package com.fit.presentation.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.auth.WelcomeScreen
import com.fit.presentation.navigation.CrutchingAdapt
import com.fit.presentation.onboarding.FirstOnboardingLauncherRoute
import com.fit.presentation.onboarding.OtherOnboardingLauncherRoute
import com.fit.presentation.onboarding.SplashLauncherRoute
import com.fit.presentation.utils.animatedComposableSlideHorizontal
import kotlinx.serialization.Serializable

@Serializable
object SplashScreen
@Serializable
object FirstOnboarding
@Serializable
object OtherOnboarding
@Serializable
object Auth

internal fun NavController.navigateToFirstOnboarding(navOptions: NavOptions? = null) {
    this.navigate(FirstOnboarding, navOptions)
}
internal fun NavController.navigateToOtherOnboarding(navOptions: NavOptions? = null) {
    this.navigate(OtherOnboarding, navOptions)
}
internal fun NavController.navigateToAuth(navOptions: NavOptions? = null) {
    this.navigate(Auth, navOptions)
}

internal inline fun <reified T : Any> NavGraphBuilder.onboardingScreen(
    noinline launcherRoute: @Composable () -> Unit
) {
    animatedComposableSlideHorizontal<T> {
        launcherRoute()
    }
}

@Composable
fun OnboardingNavHost(
    onboardingNavHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = onboardingNavHostController, startDestination = SplashScreen) {
        val onBack: () -> Unit = { onboardingNavHostController.navigateUp() }

        onboardingScreen<SplashScreen> {
            SplashLauncherRoute(onBack = onBack) {
                onboardingNavHostController.navigateToFirstOnboarding()
            }
        }
        onboardingScreen<FirstOnboarding> {
            FirstOnboardingLauncherRoute(onBack = onBack) {
                onboardingNavHostController.navigateToOtherOnboarding()
            }
        }
        onboardingScreen<OtherOnboarding> {
            OtherOnboardingLauncherRoute(onBack = onBack) {
                onboardingNavHostController.navigateToAuth()
            }
        }
        onboardingScreen<Auth> {
            CrutchingAdapt { WelcomeScreen() }
        }
    }
}
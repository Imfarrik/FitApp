package com.fit.presentation.onboarding.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.onboarding.FirstOnboardingLauncherRoute
import com.fit.presentation.onboarding.OtherOnboardingLauncherRoute
import com.fit.presentation.onboarding.SplashLauncherRoute
import com.fit.presentation.utils.navigatingToScreen
import kotlinx.serialization.Serializable

@Serializable
object SplashScreen
@Serializable
object FirstOnboarding
@Serializable
object OtherOnboarding

internal fun NavController.navigateToFirstOnboarding(navOptions: NavOptions? = null) {
    this.navigate(route = FirstOnboarding, navOptions = navOptions)
}
internal fun NavController.navigateToOtherOnboarding(navOptions: NavOptions? = null) {
    this.navigate(route = OtherOnboarding, navOptions = navOptions)
}

@Composable
fun OnboardingNavHost(
    onboardingNavHostController: NavHostController = rememberNavController(),
    navigateToAuth: () -> Unit,
) {
    NavHost(navController = onboardingNavHostController, startDestination = SplashScreen) {
        val onBack: () -> Unit = { onboardingNavHostController.navigateUp() }

        navigatingToScreen<SplashScreen> {
            SplashLauncherRoute(onBack = onBack) {
                onboardingNavHostController.navigateToFirstOnboarding()
            }
        }
        navigatingToScreen<FirstOnboarding> {
            FirstOnboardingLauncherRoute(onBack = onBack) {
                onboardingNavHostController.navigateToOtherOnboarding()
            }
        }
        navigatingToScreen<OtherOnboarding> {
            OtherOnboardingLauncherRoute(onBack = onBack) {
                navigateToAuth()
            }
        }
    }
}
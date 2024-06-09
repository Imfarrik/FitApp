package com.fit.presentation.onboarding.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.fit.presentation.onboarding.OnboardingLauncherRoute
import com.fit.presentation.utils.animatedComposableSlideHorizontal

internal const val ONBOARDING_ROUTE = "ONBOARDING_ROUTE"

internal fun NavController.navigateToOnboarding(navOptions: NavOptions? = null) {
    this.navigate(ONBOARDING_ROUTE, navOptions)
}

internal fun NavGraphBuilder.onboardingScreen(onBack: () -> Unit) {
    animatedComposableSlideHorizontal(route = ONBOARDING_ROUTE) {
        OnboardingLauncherRoute(onBack = onBack)
    }
}
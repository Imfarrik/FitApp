package com.fit.presentation.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.presentation.onboarding.navigation.SplashScreen
import com.fit.resources.theme.FitnesAppTheme

@Composable
@Preview
private fun OnboardingLauncherPreview() {
    FitnesAppTheme(dynamicColor = false) {
        OnboardingLauncherScreen()
    }
}

@Composable
internal fun OnboardingLauncherRoute(onBack: () -> Unit) {
    OnboardingLauncher(vm = hiltViewModel(), onBack = onBack)
}

@Composable
private fun OnboardingLauncher(vm: OnboardingLauncherVM, onBack: () -> Unit) {
    OnboardingLauncherScreen()
}

@Composable
private fun OnboardingLauncherScreen(
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
//            TopBar(onBack = onBack)
        },
        bottomBar = {
//            BottomBar(products = products)
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
//        Content(innerPadding = it, products = products, sentEvent = sentEvent)
    }
}
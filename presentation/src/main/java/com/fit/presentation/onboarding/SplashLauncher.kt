package com.fit.presentation.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fit.presentation.baseviews.Logotype
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    SplashLauncherScreen {}
}

@Composable
internal fun SplashLauncherRoute(
    onBack: () -> Unit,
    navigateToFirstOnboarding: () -> Unit
) {
    SplashLauncherScreen {
        navigateToFirstOnboarding()
    }
}

@Composable
private fun SplashLauncherScreen(
    navigateToFirstOnboarding: () -> Unit
) {
    LaunchedEffect(true) {
        delay(1600)
        navigateToFirstOnboarding()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Logotype(
            modifier = Modifier.fillMaxSize()
        )
    }
}
package com.fit.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.fit.presentation.navigation.CrutchingAdapt
import com.fit.resources.R
import com.fit.resources.theme.FirstOnboardingImage
import kotlinx.coroutines.delay

@Preview
@Composable
private fun FirstOnboardingScreenPreview() {
    FirstOnboardingLauncherScreen {}
}

@Composable
internal fun FirstOnboardingLauncherRoute(
    onBack: () -> Unit,
    navigateToSecondOnboarding: () -> Unit
) {
    FirstOnboardingLauncherScreen {
        navigateToSecondOnboarding()
    }
}

@Composable
private fun FirstOnboardingLauncherScreen(
    navigateToSecondOnboarding: () -> Unit
) {
    LaunchedEffect(true) {
        delay(4000)
        navigateToSecondOnboarding()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CrutchingAdapt {
            Image(
                painter = painterResource(id = R.drawable.onboarding_welcome_screen_img),
                contentDescription = FirstOnboardingImage,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}
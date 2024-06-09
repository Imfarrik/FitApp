package com.fit.presentation.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.navigation.CrutchingAdapt
import com.fit.resources.theme.DDXAcronym
import com.fit.resources.R
import com.fit.resources.theme.SplashScreenIconDescription
import com.fit.resources.theme.SplashScreenRightPartText
import com.fit.resources.theme.TextColorViolet
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Logotype(
        modifier = Modifier.fillMaxSize()
    )
}

/**
 * Загрузка 1 экрана и значка при открытии приложения
 */
@Composable
fun SplashScreenLogic(navigateToAuthScreen: () -> Unit) {
    val showSplashScreen = remember { mutableStateOf(true) }
    val showFirstOnboardingItem = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        delay(1600)
        showSplashScreen.value = false
        delay(4000)
        showFirstOnboardingItem.value = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showSplashScreen.value,
        ) {
            Logotype(
                modifier = Modifier.fillMaxSize()
            )
        }

        AnimatedVisibility(
            visible = !showSplashScreen.value,
            enter = expandHorizontally(),
            exit = fadeOut()
        ) {
            CrutchingAdapt {
                if (showFirstOnboardingItem.value)
                    FirstOnboardingScreen()
                else
                    OtherOnboardingScreen(
                        onboardingItems = ImageWithCaptionItem.onboardingItems(),
                        onNextButtonLastClick = navigateToAuthScreen
                    )
            }
        }
    }
}

@Composable
fun Logotype(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.pin_img),
            contentDescription = SplashScreenIconDescription,
        )

        val coloredText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = TextColorViolet, fontWeight = FontWeight.Bold)) {
                append(DDXAcronym)
            }
            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                append(SplashScreenRightPartText)
            }
        }

        Text(
            text = coloredText,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 36.sp
        )
    }
}
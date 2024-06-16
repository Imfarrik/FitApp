package com.fit.presentation.utils

import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal fun String?.checkForNull(): String {
    return this ?: ""
}

internal fun Long?.checkForNull(): String {
    return this?.toString() ?: ""
}

internal inline fun <reified T : Any> NavGraphBuilder.navigatingToScreen(
    noinline launcherRoute: @Composable () -> Unit
) {
    animatedComposableSlideHorizontal<T> {
        launcherRoute()
    }
}

inline fun <reified T : Any> NavGraphBuilder.animatedComposableSlideHorizontal(
    crossinline content: @Composable (NavBackStackEntry) -> Unit
) {
    composable<T>(
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 500 })
        },
        exitTransition = {
            fadeOut()
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { - 500 })
        },
        popExitTransition = {
            fadeOut()
        }
    ) {
        content(it)
    }
}

@Composable
internal fun CrutchingAdapt(composable: @Composable () -> Unit) {
    Column(
        /**
         * TODO: When UI adaptation would be resolved
         * TODO: then should kill this CRUTCH
         */
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .verticalScroll(rememberScrollState())
        ,
    ) { composable() }
}
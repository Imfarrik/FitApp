package com.fit.presentation.poll

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fit.presentation.baseviews.BasePollContainer

@Composable
internal fun PollLauncherRoute(
    pollViewModel: PollLauncherVM,
    onBack: () -> Unit,
    pollScreen: @Composable () -> Unit,
) {
    PollLauncher(
        pollViewModel = pollViewModel,
        onBack = onBack,
        pollScreen = pollScreen
    )
}

@Composable
private fun PollLauncher(
    pollViewModel: PollLauncherVM,
    onBack: () -> Unit,
    pollScreen: @Composable () -> Unit
) {
    PollLauncherScreen(
        pollViewModel = pollViewModel,
        onBack = onBack,
        pollScreen = pollScreen
    )
}

@Composable
private fun PollLauncherScreen(
    pollViewModel: PollLauncherVM,
    onBack: () -> Unit,
    pollScreen: @Composable () -> Unit
) {
    BasePollContainer(
        currentProgress = pollViewModel.progress.collectAsStateWithLifecycle().value,
        onBackButtonClick = {
            pollViewModel.toPreviousPollScreen()
            onBack()
        }
    ) { pollScreen() }
}
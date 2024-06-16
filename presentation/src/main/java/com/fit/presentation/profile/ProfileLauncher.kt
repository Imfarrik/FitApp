package com.fit.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fit.data.model.Client

@Composable
internal fun ProfileLauncherRoute(
    profileViewModel: ProfileLauncherVM,
    profileScreen: @Composable (Client?) -> Unit,
) {
    val client by profileViewModel.client.collectAsStateWithLifecycle()
    PollLauncher(
        profileViewModel = profileViewModel,
    ) { profileScreen(client) }
}

@Composable
private fun PollLauncher(
    profileViewModel: ProfileLauncherVM,
    profileScreen: @Composable () -> Unit
) {
    PollLauncherScreen(
        profileViewModel = profileViewModel,
        pollScreen = profileScreen
    )
}

@Composable
private fun PollLauncherScreen(
    profileViewModel: ProfileLauncherVM,
    pollScreen: @Composable () -> Unit
) { pollScreen() }
package com.fit.presentation.poll

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.presentation.baseviews.StubScreen

@Preview(showBackground = true)
@Composable
fun ThirdPollPreview() {
    PollScreenThird(hiltViewModel())
}

@Composable
internal fun PollScreenThird(
    pollViewModel: PollLauncherVM,
    navigateToNextScreen: () -> Unit = {}
) {
        Box(
            modifier = Modifier.padding(top = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            StubScreen(caption = "THIRD\nPOLL\nSCREEN")
        }
}
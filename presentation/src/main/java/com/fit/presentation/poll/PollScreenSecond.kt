package com.fit.presentation.poll

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.baseviews.BasePollContainer
import com.fit.presentation.splash.ImageWithCaptionItem
import com.fit.resources.theme.SecondPollScreenAdditionalCaption
import com.fit.resources.theme.SecondPollScreenMainCaption
import com.fit.resources.theme.TextColorGray

@Preview(showBackground = true)
@Composable
fun SecondPollPreview() {
    PollScreenSecond(1)
}

@Composable
fun PollScreenSecond(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit = {},
    navigateToNextScreen: () -> Unit = {}
) {
    BasePollContainer(
        currentProgress = currentProgress,
        onBackButtonClick = onBackButtonClick,
    ) {
        Column(modifier = Modifier.padding(top = 48.dp)) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = SecondPollScreenMainCaption,
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = SecondPollScreenAdditionalCaption,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
            }

            Column(modifier = Modifier.padding(top = 56.dp)) {
                ImageWithCaptionItem.secondPollScreenItems().map {
                    PollScreenItem(pollScreenItem = it) {
                        navigateToNextScreen()
                    }
                }
            }
        }
    }
}
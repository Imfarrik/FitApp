package com.fit.presentation.poll

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.presentation.splash.ImageWithCaptionItem
import com.fit.resources.theme.FirstPollScreenAdditionalCaption
import com.fit.resources.theme.FirstPollScreenMainCaption
import com.fit.resources.theme.DisabledPollScreenItemColor
import com.fit.resources.theme.EnabledPollScreenItemColor
import com.fit.resources.theme.TextColorGray

@Preview(showBackground = true)
@Composable
fun FirstPollPreview() {
    PollScreenFirst(hiltViewModel())
}

@Composable
internal fun PollScreenFirst(
    pollViewModel: PollLauncherVM,
    navigateToNextScreen: () -> Unit = {}
) {
            Column(modifier = Modifier.padding(top = 48.dp)) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = FirstPollScreenMainCaption,
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
                        text = FirstPollScreenAdditionalCaption,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextColorGray,
                        textAlign = TextAlign.Center,
                    )
                }

                Column(modifier = Modifier.padding(top = 36.dp)) {
                    ImageWithCaptionItem.firstPollScreenItems().map {
                        PollScreenItem(pollScreenItem = it) {
                            pollViewModel.toNextPollScreen()
                            navigateToNextScreen()
                        }
                    }
                }
            }
}

@Composable
internal fun PollScreenItem(
    pollScreenItem: ImageWithCaptionItem,
    onItemClick: () -> Unit = {},
) {
    ElevatedCard(
        onClick = onItemClick,
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(
            disabledContainerColor = DisabledPollScreenItemColor,
            containerColor = EnabledPollScreenItemColor,

        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .background(color = Color.Transparent)
        ) {
            Box(
                modifier = Modifier.size(96.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = pollScreenItem.image),
                    contentDescription = null,
                )
            }

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(end = 12.dp)
                ,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = pollScreenItem.mainCaption,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = pollScreenItem.additionalCaption.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextColorGray,
                        textAlign = TextAlign.Start,
                    )
                }
            }
        }
    }
}
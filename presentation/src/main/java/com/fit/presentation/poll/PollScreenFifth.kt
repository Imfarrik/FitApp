package com.fit.presentation.poll

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.presentation.baseviews.BasePollContainer
import com.fit.resources.theme.ButtonColor
import com.fit.resources.theme.ChooseTheTrainingFrequency
import com.fit.resources.theme.GrayTitle
import com.fit.resources.theme.Next
import com.fit.resources.theme.Week
import com.fit.resources.theme.trainingText
import com.fit.resources.theme.trainingText2
import com.fit.resources.theme.trainingText3


@Preview(showBackground = true)
@Composable
fun FifthPollPreview() {
    PollScreenFifth(hiltViewModel())
}

@Composable
fun PollScreenFifth(
    pollViewModel: PollLauncherVM,
    navigateToNextScreen: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 20.dp)
    ) {
            Text(
                text = ChooseTheTrainingFrequency,
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(40.dp))

            TextBlockWithCustomTexts(
                text1 = trainingText,
                text2 = "4",
                text3 = Week
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextBlockWithCustomTexts(
                text1 = trainingText2,
                text2 = "3",
                text3 = Week
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextBlockWithCustomTexts(
                text1 = trainingText3,
                text2 = "2",
                text3 = Week
            )
            Spacer(modifier = Modifier.height(250.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        pollViewModel.toNextPollScreen()
                        navigateToNextScreen()
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(55.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(ButtonColor)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = Next)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
    }

}


@Composable
fun CustomTextBlock(
    text: String,
    height: Dp,
    minTextHeight: Dp,
    maxTextHeight: Dp,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .height(height)
            .padding(start = 16.dp, end = 15.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun TextBlockWithCustomTexts(
    text1: String,
    text2: String,
    text3: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp))
            .background(GrayTitle)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(
                text = text1,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 5.dp, top = 5.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = text2,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 10.dp, end = 15.dp) // Добавлен отступ справа 15dp
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextBlock(
                text3,
                24.dp,
                24.dp,
                48.dp,
                Modifier.padding(end = 15.dp)
            ) // Добавлен отступ справа 15dp
        }
    }
}
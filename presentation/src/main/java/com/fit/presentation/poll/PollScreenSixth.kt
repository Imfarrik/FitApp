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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.resources.theme.ButtonColor
import com.fit.resources.theme.ChooseTheTrainingFrequency
import com.fit.resources.theme.DisabledButtonColor
import com.fit.resources.theme.Fitness
import com.fit.resources.theme.ICanAFew
import com.fit.resources.theme.IveBeenDoingSportsForAlongTime
import com.fit.resources.theme.Next

@Preview(showBackground = true)
@Composable
fun SixthPollPreview() {
    PollScreenSixth(hiltViewModel())
}

@Composable
fun PollScreenSixth(
    pollViewModel: PollLauncherVM,
    navigateToMain: () -> Unit = {}
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

            TextBlockWithCustomText2(
               text = Fitness
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextBlockWithCustomText2(
                text = ICanAFew
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextBlockWithCustomText2(
                text = IveBeenDoingSportsForAlongTime
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
                        navigateToMain()
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
fun TextBlockWithCustomText2(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(5.dp))
            .background(DisabledButtonColor)
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val annotatedText = buildAnnotatedString {
            val words = text.split(" ")
            words.forEachIndexed { index, word ->
                withStyle(style = SpanStyle(fontSize = if (word.equals("Фитнес?", ignoreCase = true)) 24.sp else 20.sp)) {
                    append(if (index > 0) " $word" else word)
                }
            }
        }

        Text(
            text = annotatedText,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal
        )
    }
}
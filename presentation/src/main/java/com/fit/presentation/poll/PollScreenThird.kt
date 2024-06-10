package com.fit.presentation.poll

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.baseviews.BasePollContainer
import com.fit.resources.theme.BackgroundPollScreen
import com.fit.resources.theme.DesiredWeight
import com.fit.resources.theme.Next
import com.fit.resources.theme.YourHeight
import com.fit.resources.theme.YourWeight

@Preview(showBackground = true)
@Composable
fun ThirdPollPreview() {
    PollScreenThird(3) {}
}

@Composable
fun PollScreenThird(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit,
) {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPollScreen)
    ) {
        BasePollContainer(
            currentProgress = currentProgress,
            onBackButtonClick = onBackButtonClick,
        ) {
            Column(modifier = Modifier.padding(top = 24.dp)) {
                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomBoxWithText(text = YourHeight, unit = "cm")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomBoxWithText(text = YourWeight, unit = "kg")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomBoxWithText(text = DesiredWeight, unit = "kg")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* Действие при нажатии на кнопку */ },
                        modifier = Modifier.weight(1f) .height(60.dp),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(Color.Blue)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.weight(1f))
                            Text(text = Next)
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp)) // Отступ в 20dp под кнопкой
            }
        }
    }
}

@Composable
fun CustomBoxWithText(text: String, unit: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 15.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Gray, RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .horizontalScroll(rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                ScrollingWeightPicker()

                Text(
                    text = unit,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}


@Composable
fun ScrollingWeightPicker() {
    val scrollState = rememberLazyListState()
    var weight by remember { mutableStateOf(0) }

    LaunchedEffect(weight) {
        scrollState.animateScrollToItem(weight)
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = scrollState
    ) {
        items(121) { index ->
            val currentWeight = index.toString()
            Text(
                text = currentWeight,
                fontSize = 20.sp,
                fontWeight = if (weight == index) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.clickable {
                    weight = index
                }
            )
            Spacer(modifier = Modifier.height(16.dp)) // Увеличенное расстояние между цифрами
        }
    }
}


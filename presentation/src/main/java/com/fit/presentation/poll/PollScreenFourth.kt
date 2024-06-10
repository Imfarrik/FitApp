package com.fit.presentation.poll

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.baseviews.BasePollContainer
import com.fit.resources.R
import com.fit.resources.theme.AbsAndBac
import com.fit.resources.theme.BackgroundPollScreen
import com.fit.resources.theme.Buttocks
import com.fit.resources.theme.Cardio
import com.fit.resources.theme.Chest
import com.fit.resources.theme.Legs
import com.fit.resources.theme.Next
import com.fit.resources.theme.SelectTheAreasYouWantToWorkOn

@Preview(showBackground = true)
@Composable
fun FourthPollPreview() {
    PollScreenFourth(4) {}
}

@Composable
fun PollScreenFourth(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPollScreen) // Замените Color.White на нужный цвет
    ) {
        BasePollContainer(
            currentProgress = currentProgress,
            onBackButtonClick = onBackButtonClick,
        ) {
            Column(modifier = Modifier.padding(top = 24.dp)) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = SelectTheAreasYouWantToWorkOn,
                        fontSize = 25.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.temporarily),
                                contentDescription = "Description of the image"
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = Chest,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = Cardio,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = AbsAndBac,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = Buttocks,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(Color.White)
                            ) {
                                Text(
                                    text = Legs,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { /* Действие при нажатии на кнопку */ },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(0.dp),
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
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}



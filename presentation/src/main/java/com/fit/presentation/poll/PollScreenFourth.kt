package com.fit.presentation.poll

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fit.resources.theme.AbsAndBac
import com.fit.resources.theme.Buttocks
import com.fit.resources.theme.ButtonColor
import com.fit.resources.theme.Cardio
import com.fit.resources.theme.Chest
import com.fit.resources.theme.DisabledButtonColor
import com.fit.resources.theme.Legs
import com.fit.resources.theme.Next
import com.fit.resources.theme.SelectTheAreasYouWantToWorkOn

@Preview(showBackground = true)
@Composable
fun FourthPollPreview() {
    PollScreenFourth(hiltViewModel())
}

@Composable
fun PollScreenFourth(
    pollViewModel: PollLauncherVM,
    navigateToNextScreen: () -> Unit = {}
) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
            ) {
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
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                            ,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(DisabledButtonColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = Chest,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(DisabledButtonColor)
                            ) {
                                Text(
                                    text = Cardio,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(DisabledButtonColor)
                            ) {
                                Text(
                                    text = AbsAndBac,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(DisabledButtonColor)
                            ) {
                                Text(
                                    text = Buttocks,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                            Box(
                                modifier = Modifier
                                    .size(width = 100.dp, height = 50.dp)
                                    .clip(shape = RoundedCornerShape(size = 3.dp))
                                    .background(DisabledButtonColor)
                            ) {
                                Text(
                                    text = Legs,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(bottom = 20.dp),
                                contentAlignment = Alignment.BottomCenter
                            ) {
                                Button(
                                    onClick = {
                                        pollViewModel.toNextPollScreen()
                                        navigateToNextScreen()
                                    },
                                    modifier = Modifier
                                        .padding(horizontal = 20.dp)
                                        .height(55.dp),
                                    shape = RoundedCornerShape(5.dp),
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
            }
}
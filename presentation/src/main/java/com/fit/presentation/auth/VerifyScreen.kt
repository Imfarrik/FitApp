package com.fit.presentation.auth

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.baseviews.BaseMainButton
import com.fit.resources.theme.ConfirmTheEmailAddress
import com.fit.resources.theme.CreateAccountButtonCaption
import com.fit.resources.theme.ItWillBeUpdated
import com.fit.resources.theme.PleaseOpenTheMailbox
import com.fit.resources.theme.Resend
import com.fit.resources.theme.Seconds
import com.fit.resources.theme.TextButtonColor
import com.fit.resources.theme.TextColorGray
import com.fit.resources.theme.TextColorViolet
import kotlin.concurrent.fixedRateTimer

@Preview(showBackground = true)
@Composable
private fun VerifyScreenPreview() {

    VerifyScreen()

}

@Composable
fun VerifyScreen(
    navigateToPoll: () -> Unit = {}
) {
    val textStates = remember { List(5) { mutableStateOf(TextFieldValue()) } }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .offset(y = 150.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ConfirmTheEmailAddress,
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = PleaseOpenTheMailbox,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    MultipleBasicTextFields(textStates) { index, newTextFieldValue ->
                        textStates[index].value = newTextFieldValue
                    }
                }



                Spacer(modifier = Modifier.height(15.dp))



                Spacer(modifier = Modifier.width(15.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Выравниваем по центру по горизонтали
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CounterText()
                    }



                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = Resend,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = TextButtonColor,
                            textAlign = TextAlign.Center,
                        )
                    }

                }

            }
        }


        Spacer(modifier = Modifier.height(450.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                BaseMainButton(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    caption = CreateAccountButtonCaption,
                ) { navigateToPoll() }
            }
        }
    }
}


@Composable
fun MultipleBasicTextFields(
    textStates: List<MutableState<TextFieldValue>>,
    onValueChange: (Int, TextFieldValue) -> Unit
) {
    textStates.forEachIndexed { index, state ->
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(size = 14.dp))
                .clipToBounds()
                .border(1.dp, Color.Black, RoundedCornerShape(size = 14.dp)),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                value = state.value,
                onValueChange = { onValueChange(index, TextFieldValue(it.text.take(1))) },
                textStyle = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
        Spacer(modifier = Modifier.width(3.dp))
    }
}

@Composable
fun CounterText() {
    var count by remember { mutableStateOf(53) }

    DisposableEffect(Unit) {
        val timer = fixedRateTimer(period = 1000) {
            count--
            if (count == 0) {
                cancel()
            }
        }

        onDispose {
            timer.cancel()
        }
    }

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = ItWillBeUpdated,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextButtonColor,
            textAlign = TextAlign.Center,
        )

        Text(
            text = count.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextColorViolet,
            textAlign = TextAlign.Center,
        )

        Text(
            text = Seconds,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = TextButtonColor,
            textAlign = TextAlign.Center,
        )
    }
}








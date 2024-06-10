package com.fit.presentation.baseviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.resources.R
import com.fit.resources.theme.DDXAcronym
import com.fit.resources.theme.SplashScreenIconDescription
import com.fit.resources.theme.SplashScreenRightPartText
import com.fit.resources.theme.TextColorViolet

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Logotype(modifier = Modifier.fillMaxSize())
}

@Composable
fun Logotype(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.pin_img),
            contentDescription = SplashScreenIconDescription,
        )

        val coloredText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = TextColorViolet, fontWeight = FontWeight.Bold)) {
                append(DDXAcronym)
            }
            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                append(SplashScreenRightPartText)
            }
        }

        Text(
            text = coloredText,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 36.sp
        )
    }
}
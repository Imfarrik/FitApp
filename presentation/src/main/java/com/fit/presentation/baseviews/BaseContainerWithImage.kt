package com.fit.presentation.baseviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fit.presentation.splash.ImageWithCaptionItem
import com.fit.resources.theme.DDXAcronym
import com.fit.resources.theme.ExclamationPoint
import com.fit.resources.theme.BaseContainerImage
import com.fit.resources.theme.OtherOnboardingThirdCaptionOne
import com.fit.resources.theme.TextColorGray
import com.fit.resources.theme.TextColorViolet

@Composable
fun BaseContainerWithImage(item: ImageWithCaptionItem) {
    val isLastOnboardingScreen = item.mainCaption == OtherOnboardingThirdCaptionOne

    Column(modifier = Modifier.wrapContentSize()) {
        Image(
            painter = painterResource(id = item.image),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = BaseContainerImage,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-16).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = if (isLastOnboardingScreen) 23.sp else 24.sp,
                            )
                        ) { append(item.mainCaption) }
                        if (isLastOnboardingScreen) {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 23.sp,
                                    color = TextColorViolet
                                )
                            ) { append(DDXAcronym) }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 23.sp,
                                )
                            ) { append(ExclamationPoint) }
                        }
                    },
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            item.additionalCaption?. let { string ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = string,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextColorGray,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
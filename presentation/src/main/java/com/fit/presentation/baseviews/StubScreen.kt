package com.fit.presentation.baseviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun StubScreenPreview() {
    StubScreen()
}

@Composable
fun StubScreen(
    caption: String = "Hello, friends!"
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .scale(3f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = caption)

//        Image(
//            painter = painterResource(R.drawable.ic_launcher_foreground),
//            contentDescription = null
//        )
    }
}
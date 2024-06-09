package com.fit.presentation.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fit.resources.theme.TextColorViolet

@Composable
fun SliderWithIndicator(
    modifier: Modifier = Modifier,
    currentPageIndex: Int,
    onboardingItemsIndexes: List<Int>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row {
            onboardingItemsIndexes.map {
                Dot(isActive = currentPageIndex == it)
                if (it != onboardingItemsIndexes.lastIndex)
                    Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}


@Composable
fun Dot(isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(
                width = if (isActive) 24.dp else 12.dp,
                height = 12.dp
            )
            .background(
                color = if (isActive) TextColorViolet else Color.Gray,
                shape = if (isActive) RoundedCornerShape(6.dp) else CircleShape
            )
    )
}




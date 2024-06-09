package com.fit.presentation.baseviews

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fit.resources.theme.DisabledButtonColor
import com.fit.resources.theme.SplashScreenIconDescription
import com.fit.resources.theme.TextColorViolet

@Preview
@Composable
fun EnabledBaseMainButtonPreview() {
    BaseMainButton(
        caption = SplashScreenIconDescription
    )
}

@Preview
@Composable
fun DisnabledBaseMainButtonPreview() {
    BaseMainButton(
        caption = SplashScreenIconDescription,
        enabled = false
    )
}

@Composable
fun BaseMainButton(
    modifier: Modifier = Modifier,
    caption: String = "",
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        shape = RoundedCornerShape(size = 12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = TextColorViolet,
            disabledContainerColor = DisabledButtonColor
        ),
    ) {
        Text(
            text = caption,
            color = Color.White
        )
    }
}
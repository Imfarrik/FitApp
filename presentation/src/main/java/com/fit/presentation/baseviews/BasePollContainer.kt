package com.fit.presentation.baseviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fit.data.Constants
import com.fit.resources.R
import com.fit.resources.theme.BackButtonCaption
import com.fit.resources.theme.TextButtonColor

@Preview(showBackground = true)
@Composable
private fun BasePollContainerPreview() {
    BasePollContainer(currentProgress = 2)
}

@Composable
fun BasePollContainer(
    currentProgress: Int = 0,
    onBackButtonClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val progress =
            currentProgress.toFloat()
                .div(Constants.POLL_SCREENS_COUNT)
    fun Modifier.indicatorShadow() =
        shadow(
            elevation = 4.dp,
            spotColor = TextButtonColor,
            shape = ShapeDefaults.ExtraLarge
        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
//            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            val bckBtn = createRef()

            /**
             * Back button
             */
            Image(
                painter = painterResource(id = R.drawable.ic_back_button),
                contentDescription = BackButtonCaption,
                modifier = Modifier
                    .constrainAs(bckBtn) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .indicatorShadow()
                    .clickable { onBackButtonClick() }
            )

            /**
             * Poll filling indicator
             */
            Row(
                modifier = Modifier
                    .constrainAs(createRef()) {
                        top.linkTo(bckBtn.top)
                        bottom.linkTo(bckBtn.bottom)
                        start.linkTo(bckBtn.end)
                        end.linkTo(parent.end)
                    }
            ) {
                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier.indicatorShadow(),
                    color = Color.Blue,
                    trackColor = Color.White,
                )
            }
        }

        content()
    }
}
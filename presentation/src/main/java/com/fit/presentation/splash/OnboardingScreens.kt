package com.fit.presentation.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fit.presentation.baseviews.BaseContainerWithImage
import com.fit.presentation.baseviews.BaseMainButton
import com.fit.resources.theme.FirstOnboardingImage
import com.fit.resources.theme.NextButtonCaption
import com.fit.resources.R

@Preview
@Composable
fun FirstOnboardingScreenPreview() {
    FirstOnboardingScreen()
}

@Preview
@Composable
fun OtherOnboardingItemPreview() {
    BaseContainerWithImage(
        item =
            ImageWithCaptionItem.onboardingItems()[0]
    )
}

@Preview
@Composable
fun OtherOnboardingScreenPreview() {
    OtherOnboardingScreen(
        onboardingItems =
            ImageWithCaptionItem.onboardingItems()
    )
}

@Composable
fun FirstOnboardingScreen() {
    Image(
        painter = painterResource(id = R.drawable.onboarding_welcome_screen_img),
        contentDescription = FirstOnboardingImage,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OtherOnboardingScreen(
    onboardingItems: List<ImageWithCaptionItem>,
    onNextButtonLastClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(
        pageCount = { onboardingItems.size }
    )
    val currentPageIndex by remember {
        derivedStateOf { pagerState.currentPage }
    }
    val shouldScrollPager = rememberSaveable {
        mutableStateOf(false)
    }
    val setShouldScrollPagerTrue = {
        shouldScrollPager.value = true
    }

    if (shouldScrollPager.value)
        LaunchedEffect(key1 = null) {
            pagerState.scrollToPage(currentPageIndex + 1)
            shouldScrollPager.value = false
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            modifier = Modifier.wrapContentSize(),
            state = pagerState,
            pageSize = PageSize.Fill
        ) { pageIndex ->
            BaseContainerWithImage(
                item = onboardingItems[pageIndex]
            )
        }

        SliderWithIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            currentPageIndex = currentPageIndex,
            onboardingItemsIndexes = List(onboardingItems.size) { it }
        )

        /**
         * Кнопка "Далее" для перехода к следующему экрану
         */
        BaseMainButton(
            onClick =
            if (currentPageIndex == onboardingItems.lastIndex)
                onNextButtonLastClick
            else
                setShouldScrollPagerTrue,
            caption = NextButtonCaption,
            modifier = Modifier.padding(all = 12.dp),
            )
    }
}
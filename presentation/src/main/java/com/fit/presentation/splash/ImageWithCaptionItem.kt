package com.fit.presentation.splash

import androidx.annotation.DrawableRes
import com.fit.resources.R
import com.fit.resources.theme.FifthPollItemAdditionalCaption
import com.fit.resources.theme.FifthPollItemMainCaption
import com.fit.resources.theme.FirstPollItemAdditionalCaption
import com.fit.resources.theme.FirstPollItemMainCaption
import com.fit.resources.theme.ForthPollItemAdditionalCaption
import com.fit.resources.theme.ForthPollItemMainCaption
import com.fit.resources.theme.OtherOnboardingFirstCaption
import com.fit.resources.theme.OtherOnboardingLatinCaption
import com.fit.resources.theme.OtherOnboardingSecondCaption
import com.fit.resources.theme.OtherOnboardingThirdCaptionOne
import com.fit.resources.theme.OtherOnboardingThirdCaptionTwo
import com.fit.resources.theme.SecondPollItemAdditionalCaption
import com.fit.resources.theme.SecondPollItemMainCaption
import com.fit.resources.theme.SixthPollItemAdditionalCaption
import com.fit.resources.theme.SixthPollItemMainCaption
import com.fit.resources.theme.ThirdPollItemAdditionalCaption
import com.fit.resources.theme.ThirdPollItemMainCaption
import com.fit.resources.theme.WelcomeScreenAdditionalCaption
import com.fit.resources.theme.WelcomeScreenMainCaption

data class ImageWithCaptionItem(
    @DrawableRes
    val image: Int,
    val mainCaption: String,
    val additionalCaption: String? = null
) {
    companion object {
        fun onboardingItems() = listOf(
            ImageWithCaptionItem(
                image = R.drawable.onboarding2_img,
                mainCaption = OtherOnboardingFirstCaption,
                additionalCaption = OtherOnboardingLatinCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.onboarding3_img,
                mainCaption = OtherOnboardingSecondCaption,
                additionalCaption = OtherOnboardingLatinCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.onboarding4_img,
                mainCaption = OtherOnboardingThirdCaptionOne,
                additionalCaption = OtherOnboardingThirdCaptionTwo
            ),
        )

        fun welcomeScreenItem() = ImageWithCaptionItem(
            image = R.drawable.welcome_screen_background_photo,
            mainCaption = WelcomeScreenMainCaption,
            additionalCaption = WelcomeScreenAdditionalCaption,
        )

        fun firstPollScreenItems() = listOf(
            ImageWithCaptionItem(
                image = R.drawable.ic_weight_loss_48,
                mainCaption = FirstPollItemMainCaption,
                additionalCaption = FirstPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_stay_in_form_48,
                mainCaption = SecondPollItemMainCaption,
                additionalCaption = SecondPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_mass_increase_48,
                mainCaption = ThirdPollItemMainCaption,
                additionalCaption = ThirdPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_dumbbell,
                mainCaption = ForthPollItemMainCaption,
                additionalCaption = ForthPollItemAdditionalCaption
            ),
        )

        fun secondPollScreenItems() = listOf(
            ImageWithCaptionItem(
                image = R.drawable.ic_to_wide_limits_48,
                mainCaption = FifthPollItemMainCaption,
                additionalCaption = FifthPollItemAdditionalCaption
            ),
            ImageWithCaptionItem(
                image = R.drawable.ic_pleasure_from_training_48,
                mainCaption = SixthPollItemMainCaption,
                additionalCaption = SixthPollItemAdditionalCaption
            ),
        )
    }
}
package com.fit.presentation.poll.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.poll.PollLauncherRoute
import com.fit.presentation.poll.PollScreenFirst
import com.fit.presentation.poll.PollScreenSecond
import com.fit.presentation.poll.PollScreenThird
import com.fit.presentation.poll.PollLauncherVM
import com.fit.presentation.utils.navigatingToScreen
import kotlinx.serialization.Serializable

@Serializable
object FirstPollScreen
@Serializable
object SecondPollScreen
@Serializable
object ThirdPollScreen
@Serializable
object ForthPollScreen
@Serializable
object FifthPollScreen
@Serializable
object SixthPollScreen

internal fun NavController.navigateToSecondPoll(navOptions: NavOptions? = null) {
    this.navigate(route = SecondPollScreen, navOptions = navOptions)
}

internal fun NavController.navigateToThirdPoll(navOptions: NavOptions? = null) {
    this.navigate(route = ThirdPollScreen, navOptions = navOptions)
}

internal fun NavController.navigateToForthPoll(navOptions: NavOptions? = null) {
    this.navigate(route = ForthPollScreen, navOptions = navOptions)
}

internal fun NavController.navigateToFifthPoll(navOptions: NavOptions? = null) {
    this.navigate(route = FifthPollScreen, navOptions = navOptions)
}

internal fun NavController.navigateToSixthPoll(navOptions: NavOptions? = null) {
    this.navigate(route = SixthPollScreen, navOptions = navOptions)
}

@Composable
fun PollNavHost(
    pollNavHostController: NavHostController = rememberNavController(),
    pollViewModel: PollLauncherVM = hiltViewModel<PollLauncherVM>(),
    navigateToMain: () -> Unit,
) {
    PollLauncherRoute(
        pollViewModel = pollViewModel,
        onBack = { pollNavHostController.navigateUp() }
    ) {
        NavHost(
            navController = pollNavHostController,
            startDestination = FirstPollScreen,
        ) {
            navigatingToScreen<FirstPollScreen> {
                PollScreenFirst(pollViewModel = pollViewModel) {
                    pollNavHostController.navigateToSecondPoll()
                }
            }
            navigatingToScreen<SecondPollScreen> {
                PollScreenSecond(pollViewModel = pollViewModel) {
                    pollNavHostController.navigateToThirdPoll()
                }
            }
            navigatingToScreen<ThirdPollScreen> {
                PollScreenThird(pollViewModel = pollViewModel) {
//                    pollNavHostController.navigateToForthPoll()
                }
            }
        }
    }
}

fun NavHostController.navigateBack(
    routeTo: String = "",
    routeFrom: String = "",
) {
    navigate(routeTo) {
        popUpTo(routeFrom) {
            inclusive = true
        }
    }
}
package com.fit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.poll.PollScreenFirst
import com.fit.presentation.poll.PollScreenSecond
import com.fit.presentation.poll.PollScreenThird
import com.fit.presentation.poll.PollViewModel

@Composable
fun PollNavHost(
    pollNavHostController: NavHostController = rememberNavController(),
    pollViewModel: PollViewModel = viewModel<PollViewModel>()
) {
    NavHost(
        navController = pollNavHostController,
        startDestination = PollScreen.FirstPoll.route,
    ) {
        composable(route = PollScreen.FirstPoll.route) {
            PollScreenFirst(
                currentProgress = pollViewModel.progress,
                onBackButtonClick = {
                    pollNavHostController.navigateBack(
                        routeTo = PollScreen.FirstPoll.route,
                        routeFrom = PollScreen.FirstPoll.route
                    )
                }
            ) {
                pollViewModel.toNextPollScreen()
                pollNavHostController.navigate(PollScreen.SecondPoll.route)
            }
        }
        composable(route = PollScreen.SecondPoll.route) {
            PollScreenSecond(
                currentProgress = pollViewModel.progress,
                onBackButtonClick = {
                    pollViewModel.toPreviousPollScreen()
                    pollNavHostController.navigateBack(
                        routeTo = PollScreen.FirstPoll.route,
                        routeFrom = PollScreen.SecondPoll.route
                    )
                }
            ) {
                pollViewModel.toNextPollScreen()
                pollNavHostController.navigate(PollScreen.ThirdPoll.route)
            }
        }
        composable(route = PollScreen.ThirdPoll.route) {
            PollScreenThird(
                currentProgress = pollViewModel.progress,
                onBackButtonClick = {
                    pollViewModel.toPreviousPollScreen()
                    pollNavHostController.navigateBack(
                        routeTo = PollScreen.SecondPoll.route,
                        routeFrom = PollScreen.ThirdPoll.route
                    )
                }
            )
        }
    }
}

sealed class PollScreen(val route: String) {
    companion object {
        const val FIRST_POLL_SCREEN = "first_poll_screen"
        const val SECOND_POLL_SCREEN = "second_poll_screen"
        const val THIRD_POLL_SCREEN = "third_poll_screen"
        const val FORTH_POLL_SCREEN = "forth_poll_screen"
        const val FIFTH_POLL_SCREEN = "fifth_poll_screen"
        const val SIXTH_POLL_SCREEN = "sixth_poll_screen"
        const val SEVENTH_POLL_SCREEN = "seventh_poll_screen"
    }
    data object FirstPoll: PollScreen(FIRST_POLL_SCREEN)
    data object SecondPoll: PollScreen(SECOND_POLL_SCREEN)
    data object ThirdPoll: PollScreen(THIRD_POLL_SCREEN)
    data object ForthPoll: PollScreen(FORTH_POLL_SCREEN)
    data object FifthPoll: PollScreen(FIFTH_POLL_SCREEN)
    data object SixthPoll: PollScreen(SIXTH_POLL_SCREEN)
    data object SeventhPoll: PollScreen(SEVENTH_POLL_SCREEN)
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
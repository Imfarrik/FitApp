package com.fit.presentation.profile.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fit.presentation.profile.HomePageScreen
import com.fit.presentation.profile.ProfileLauncherRoute
import com.fit.presentation.profile.ProfileLauncherVM
import com.fit.presentation.profile.RatePageScreen
import com.fit.presentation.utils.navigatingToScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeScreen
@Serializable
object RateScreen

internal fun NavController.navigateToRate(navOptions: NavOptions? = null) {
    this.navigate(route = RateScreen, navOptions = navOptions)
}

@Composable
fun ProfileNavHost(
    profileNavHostController: NavHostController = rememberNavController(),
    profileViewModel: ProfileLauncherVM = hiltViewModel<ProfileLauncherVM>(),
) {
    ProfileLauncherRoute(
        profileViewModel = profileViewModel,
    ) {
        NavHost(
            navController = profileNavHostController,
            startDestination = HomeScreen,
        ) {
            navigatingToScreen<HomeScreen> {
                HomePageScreen { profileNavHostController.navigateToRate() }
            }
            navigatingToScreen<RateScreen> {
                RatePageScreen { profileNavHostController.navigateUp() }
            }
        }
    }
}

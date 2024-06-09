package com.fit.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fit.presentation.auth.AuthViewModel
import com.fit.presentation.auth.LoginScreen
import com.fit.presentation.auth.StateHandler
import com.fit.presentation.auth.VerifyScreen
import com.fit.presentation.auth.WelcomeScreen
import com.fit.presentation.baseviews.StubScreen
import com.fit.presentation.splash.SplashScreenLogic

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
            navigation(
                route = Graph.AUTH,
                startDestination = AuthScreen.Splash.route
            ) {
                composable(route = AuthScreen.Splash.route) {
                    SplashScreenLogic(
                        navigateToAuthScreen = {
                            rootNavController.navigate(route = AuthScreen.WELCOME_SCREEN) {
                                popUpTo(rootNavController.graph.id) { inclusive = true }
                            }
                        }
                    )
                }
                composable(route = AuthScreen.Welcome.route) {
                    CrutchingAdapt {
                        WelcomeScreen(
                            navigateToCreate = {
                                rootNavController.navigate(AuthScreen.Login.route)
                            },
                            navigateToMain = {
                                rootNavController.navigate(AuthScreen.Main.route)
                            }
                        )
                    }
                }
                composable(route = AuthScreen.Login.route) {
                    LoginScreen {
                        rootNavController.navigate(AuthScreen.Verify.route)
                    }
                }
                composable(route = AuthScreen.Verify.route) {
                    VerifyScreen {
                        rootNavController.navigate(AuthScreen.Poll.route)
                    }
                }
                composable(route = AuthScreen.Poll.route) {
                    CrutchingAdapt { PollNavHost() }
                }
                composable(route = AuthScreen.Main.route) {
                    // TODO: Add nested navigation for MainCase
                    StubScreen(caption = AuthScreen.MAIN_SCREEN)
                }
            }
}

sealed class AuthScreen(val route: String) {
    companion object {
        const val SPLASH_SCREEN = "splash_screen"
        const val WELCOME_SCREEN = "welcome_screen"
        const val LOGIN_SCREEN = "login_screen"
        const val VERIFY_SCREEN = "confirm_screen"
        const val POLL_SCREEN = "poll_screen"
        const val MAIN_SCREEN = "main_screen"
    }
    data object Splash: AuthScreen(SPLASH_SCREEN)
    data object Welcome: AuthScreen(WELCOME_SCREEN)
    data object Login: AuthScreen(LOGIN_SCREEN)
    data object Verify: AuthScreen(VERIFY_SCREEN)
    data object Poll: AuthScreen(POLL_SCREEN)
    data object Main: AuthScreen(MAIN_SCREEN)
}

@Composable
fun NavHostController.WithAuthViewModel(
    authViewModel: AuthViewModel = viewModel<AuthViewModel>(),
    composable: @Composable (AuthViewModel) -> Unit
) {
    authViewModel.authState
        .collectAsState()
        .value
        .StateHandler(
            onDismissRequest = { authViewModel.onErrorAction() }
        ) { composable(authViewModel) }
}

@Composable
fun CrutchingAdapt(composable: @Composable () -> Unit) {
    Column(
        /**
         * TODO: When UI adaptation would be resolved
         * TODO: then should kill this CRUTCH
         */
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) { composable() }
}
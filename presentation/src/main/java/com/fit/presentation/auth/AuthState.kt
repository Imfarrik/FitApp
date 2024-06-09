package com.fit.presentation.auth

import androidx.compose.runtime.Composable

sealed interface AuthState {
    data object Loading: AuthState
    data object Error: AuthState
    data object Success: AuthState
}

@Composable
fun AuthState?.StateHandler(
    onDismissRequest: () -> Unit,
    composeAfterSuccess: @Composable () -> Unit
) {
    composeAfterSuccess()
}
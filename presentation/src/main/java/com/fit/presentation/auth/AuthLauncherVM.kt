package com.fit.presentation.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit.data.model.LoginRequest
import com.fit.data.model.VerifyRequest
import com.fit.domain.onFailure
import com.fit.domain.onSuccess
import com.fit.domain.useCases.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthLauncherVM @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel() {
    private val _authState = MutableStateFlow<AuthState?>(null)
    val authState: StateFlow<AuthState?>
        get() = _authState.asStateFlow()
    val isAuthorized: Boolean
        get() = true

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authUseCase.createUser(loginRequest).onSuccess {
                Log.d("SUCCESS USER CREATE", "USER:\n$it")
                _authState.value = AuthState.Success
            }
                .onFailure {
                    _authState.value = AuthState.Error
                }

        }
    }

    fun verify(verifyRequest: VerifyRequest) {
        viewModelScope.launch {

        }
    }

    fun onErrorAction() {
        _authState.value = null
    }
}
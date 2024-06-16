package com.fit.presentation.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit.data.model.Client
import com.fit.data.model.Resource
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

    fun login(loginRequest: Client) {
        viewModelScope.launch {
            authUseCase.createUser(loginRequest).fetchingData {
                Log.d("SUCCESS USER CREATE", "USER:\n$it")
            }
        }
    }

    fun verify(verifyRequest: VerifyRequest) {
        viewModelScope.launch {
            authUseCase.verifyEmail(verifyRequest).fetchingData {
                Log.d("SUCCESS USER VERIFY", "token: ${it.token}")
            }
        }
    }

    fun onErrorAction() {
        _authState.value = null
    }

    private inline fun <T> Resource<T>
            .fetchingData(action: (value: T) -> Unit) {
        _authState.value = AuthState.Loading
        onSuccess {
            action(it)
            _authState.value = AuthState.Success
        }
            .onFailure {
                _authState.value = AuthState.Error
            }
    }
}
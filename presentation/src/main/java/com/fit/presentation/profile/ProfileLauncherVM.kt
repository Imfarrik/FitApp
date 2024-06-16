package com.fit.presentation.profile

import androidx.lifecycle.ViewModel
import com.fit.data.model.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileLauncherVM @Inject constructor(

): ViewModel() {
    private var _client = MutableStateFlow<Client?>(null)
    val client: StateFlow<Client?>
        get() = _client.asStateFlow()

    fun getUser(id: Int) {

    }
}
package com.fit.presentation.poll

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PollLauncherVM @Inject constructor(

): ViewModel() {
    private var _progress = MutableStateFlow(0)
    val progress: StateFlow<Int>
        get() = _progress.asStateFlow()

    fun toNextPollScreen() {
        _progress.value += 1
    }

    fun toPreviousPollScreen() {
        if (_progress.value > 0)
            _progress.value -= 1
    }
}
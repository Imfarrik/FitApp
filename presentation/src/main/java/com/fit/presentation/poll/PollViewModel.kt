package com.fit.presentation.poll

import androidx.lifecycle.ViewModel

class PollViewModel : ViewModel() {
    private var _progress: Int = 0
    val progress: Int
        get() = _progress

    fun toNextPollScreen() {
        _progress += 1
    }

    fun toPreviousPollScreen() {
        _progress -= 1
    }
}
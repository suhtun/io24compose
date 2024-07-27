package com.su.io24_compose_experimental.pulltorefresh

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PullToRefreshViewModel: ViewModel() {

    private val refreshRequests = Channel<Unit>(1)

    var isRefreshing by mutableStateOf(false)
        private set

    var itemCount by mutableStateOf(5)
        private set

    init {
        viewModelScope.launch {
            for (r in refreshRequests) {
                isRefreshing = true
                try {
                    delay(1000) // simulate doing real work
                    itemCount += 1
                } finally {
                    isRefreshing = false
                }
            }
        }
    }

    fun refresh() {
        refreshRequests.trySend(Unit)
    }
}
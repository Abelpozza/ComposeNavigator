package com.abel.jetpackprojeto.presentation.viewmodel

import android.R
import android.os.Message
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow


class RedirectViewModel : ViewModel() {

    private val _snackbarEvent = MutableSharedFlow<String>()
    val snackbarEvent = _snackbarEvent.asSharedFlow()

    suspend fun showMessage(message: String) {
        _snackbarEvent.emit(message)
    }
}
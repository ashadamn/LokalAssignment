package com.example.lokalassignment.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.lokalassignment.domain.util.ApiResult
import com.example.lokalassignment.util.showToast

@Composable
fun <T> UiStateHandler(
    uiState: ApiResult<T>,
    onIdle: @Composable () -> Unit = {},
    onLoading: (@Composable () -> Unit)? = null,
    errorMessageUi: (@Composable () -> Unit)? = null,
    onSuccess: @Composable (data: T) -> Unit,
) {
    val context = LocalContext.current

    when (uiState) {
        is ApiResult.Success -> {
            onSuccess.invoke(uiState.data)
        }

        is ApiResult.Idle -> {
            onIdle.invoke()
        }

        is ApiResult.Loading -> {
            if (onLoading == null) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                onLoading.invoke()
            }
        }

        is ApiResult.NoInternet -> {
            context.showToast("No Internet")
        }

        is ApiResult.ErrorMessage -> {
            errorMessageUi?.invoke() ?: Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = uiState.message)
            }
        }
    }
}
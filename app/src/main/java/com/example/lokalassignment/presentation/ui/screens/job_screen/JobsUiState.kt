package com.example.lokalassignment.presentation.ui.screens.job_screen

import androidx.compose.runtime.Stable
import com.example.lokalassignment.data.model.JobsDTO

@Stable
data class JobsUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: JobsDTO? = null,
    val isFirstTimeLoading: Boolean = true,
)
package com.example.lokalassignment.presentation.ui.screens.jobs_details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalassignment.data.repository.AppRepository
import com.example.lokalassignment.data.source.local.JobEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JobsDetailsViewModel(
    private val repository: AppRepository,
) : ViewModel() {

    private val _isBookmarked = MutableStateFlow(false)
    val isBookmarked: StateFlow<Boolean> = _isBookmarked.asStateFlow()

    fun isBookMarked(job: JobEntity) {
        viewModelScope.launch {
            _isBookmarked.value = repository.isJobBookmarked(job.id)
        }
    }

    fun toggleBookmark(job: JobEntity) {
        viewModelScope.launch {
            val isBookmarked = repository.isJobBookmarked(job.id)
            if (isBookmarked) {
                repository.deleteJob(job.id)
            } else {
                repository.upsertJob(job)
            }
            isBookMarked(job)
        }
    }

}
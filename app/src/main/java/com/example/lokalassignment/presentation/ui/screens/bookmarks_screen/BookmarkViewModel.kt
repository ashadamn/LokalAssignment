package com.example.lokalassignment.presentation.ui.screens.bookmarks_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalassignment.data.repository.AppRepository
import com.example.lokalassignment.data.source.local.JobEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookmarkViewModel(
    private val repository: AppRepository,
) : ViewModel() {

    private val _bookmarkedJobs = MutableStateFlow<List<JobEntity>>(emptyList())
    val bookmarkedJobs: StateFlow<List<JobEntity>> = _bookmarkedJobs.asStateFlow()

    init {
        getJobsFromDb()
    }

    private fun getJobsFromDb() {
        viewModelScope.launch {
            repository.getJobsFromDb().collect { jobs ->
                _bookmarkedJobs.value = jobs
            }
        }
    }

}
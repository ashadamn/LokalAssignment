package com.example.lokalassignment.presentation.ui.screens.shared_view_model

import androidx.lifecycle.ViewModel
import com.example.lokalassignment.data.model.Results
import com.example.lokalassignment.data.source.local.JobEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedJobViewModel : ViewModel() {
    private val _selectedJob = MutableStateFlow<JobEntity?>(null)
    val selectedJob: StateFlow<JobEntity?> = _selectedJob

    fun setJob(job: JobEntity) {
        _selectedJob.value = job
    }
}

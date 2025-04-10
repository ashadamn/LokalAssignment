package com.example.lokalassignment.presentation.ui.screens.job_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lokalassignment.data.model.JobsDTO
import com.example.lokalassignment.data.model.Results
import com.example.lokalassignment.data.repository.AppRepository
import com.example.lokalassignment.domain.util.ApiResult
import com.example.lokalassignment.domain.util.toApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class JobsViewModel(
    private val repository: AppRepository,
) : ViewModel() {

    private val _jobsListState =
        MutableStateFlow(JobsUiState())
    val jobsListState: StateFlow<JobsUiState> = _jobsListState.asStateFlow()


    private var currentPage = 1
    private var isLoading = false
    private var hasMoreData = true

    private val allJobs = mutableListOf<Results>()

    init {
        loadJobsList()
    }

    fun loadJobsList() {
        if (isLoading || !hasMoreData) return

        isLoading = true
        _jobsListState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val response = repository.getJobs(currentPage)
            when (val result = response.toApiResult()) {
                is ApiResult.Success -> {
                    val newJobs = result.data.results
                    if (newJobs.isNotEmpty()) {
                        allJobs.addAll(newJobs)
                        currentPage++
                    } else {
                        hasMoreData = false
                    }
                    _jobsListState.update {
                        it.copy(
                            data = JobsDTO(results = allJobs as ArrayList<Results>),
                            isLoading = false,
                            error = null,
                            isFirstTimeLoading = false
                        )
                    }
                }

                is ApiResult.ErrorMessage -> {
                    _jobsListState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message,
                            isFirstTimeLoading = false
                        )
                    }
                }


                is ApiResult.NoInternet -> {
                    _jobsListState.update {
                        it.copy(
                            isLoading = false,
                            error = "No Internet",
                            isFirstTimeLoading = false,
                            data = JobsDTO(results = allJobs as ArrayList<Results>)
                        )
                    }
                }

                else -> {

                }
            }

            isLoading = false
        }
    }

}
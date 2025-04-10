package com.example.lokalassignment.data.repository

import com.example.lokalassignment.data.model.JobsDTO
import com.example.lokalassignment.data.source.local.JobDao
import com.example.lokalassignment.data.source.local.JobEntity
import com.example.lokalassignment.data.source.remote.AppApiService
import com.example.lokalassignment.data.util.ResponseState
import com.example.lokalassignment.data.util.getApiResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class AppRepositoryImpl(
    private val apiService: AppApiService,
    private val dao: JobDao,
) : AppRepository {

    override suspend fun getJobs(page: Int): ResponseState<JobsDTO> {
        return getApiResponseState {
            withContext(Dispatchers.IO) {
                apiService.getJobs(page)
            }
        }
    }

    override suspend fun upsertJob(job: JobEntity) {
        dao.upsertJob(job)
    }

    override suspend fun deleteJob(id: Int) {
        dao.deleteJob(id)
    }

    override fun getJobsFromDb(): Flow<List<JobEntity>> {
        return dao.getJobs()
    }

    override suspend fun isJobBookmarked(id: Int): Boolean {
        return dao.isJobBookmarked(id)
    }

}
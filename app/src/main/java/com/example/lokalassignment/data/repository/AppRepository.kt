package com.example.lokalassignment.data.repository

import com.example.lokalassignment.data.model.JobsDTO
import com.example.lokalassignment.data.source.local.JobEntity
import com.example.lokalassignment.data.util.ResponseState
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getJobs(page: Int): ResponseState<JobsDTO>

    suspend fun upsertJob(job: JobEntity)

    suspend fun deleteJob(id: Int)

    fun getJobsFromDb(): Flow<List<JobEntity>>

    suspend fun isJobBookmarked(id: Int): Boolean

}
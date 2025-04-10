package com.example.lokalassignment.data.source.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface JobDao {

    @Upsert
    suspend fun upsertJob(job: JobEntity)

    @Query("DELETE FROM jobentity WHERE id = :id")
    suspend fun deleteJob(id: Int)

    @Query("SELECT * FROM jobentity")
    fun getJobs(): Flow<List<JobEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM jobentity WHERE id = :id)")
    suspend fun isJobBookmarked(id: Int): Boolean

}
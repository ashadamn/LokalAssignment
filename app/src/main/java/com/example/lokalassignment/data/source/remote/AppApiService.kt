package com.example.lokalassignment.data.source.remote

import com.example.lokalassignment.data.model.JobsDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AppApiService(private val client: HttpClient) {

    suspend fun getJobs(page: Int): JobsDTO {
        return client.get("common/jobs") {
            url {
                parameters.append("page", page.toString())
            }
        }.body()
    }


}

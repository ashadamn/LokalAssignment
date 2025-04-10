package com.example.lokalassignment.data.mappers

import com.example.lokalassignment.data.model.Results
import com.example.lokalassignment.data.source.local.JobEntity

fun Results.toJobEntity(): JobEntity {
    return JobEntity(
        id = id!!,
        title = title ?: "Null",
        location = primaryDetails?.Place ?: "Null",
        salary = primaryDetails?.Salary ?: "Null",
        phone = whatsappNo ?: "Null",
        otherDetails = otherDetails ?: "Null",
        customLink = customLink ?: "Null"
    )
}
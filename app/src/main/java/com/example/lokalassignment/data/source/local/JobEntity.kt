package com.example.lokalassignment.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JobEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val location: String,
    val salary: String,
    val phone: String,
    val otherDetails: String,
    val customLink: String,
)
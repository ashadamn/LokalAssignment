package com.example.lokalassignment.di

import android.content.Context
import androidx.room.Room
import com.example.lokalassignment.data.source.local.JobDatabase

object DatabaseProvider {

    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context, JobDatabase::class.java, "jobs.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    fun provideDao(database: JobDatabase) = database.dao

}
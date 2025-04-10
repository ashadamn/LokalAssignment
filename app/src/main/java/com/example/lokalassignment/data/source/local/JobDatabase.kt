package com.example.lokalassignment.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [JobEntity::class],
    version = 2,
    exportSchema = false
)
abstract class JobDatabase : RoomDatabase() {
    abstract val dao: JobDao
}
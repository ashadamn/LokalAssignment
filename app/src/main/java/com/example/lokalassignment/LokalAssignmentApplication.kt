package com.example.lokalassignment

import android.app.Application
import com.example.lokalassignment.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LokalAssignmentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LokalAssignmentApplication)
            modules(appModule)
        }
    }

}
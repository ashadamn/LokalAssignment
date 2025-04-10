package com.example.lokalassignment.di


import com.example.lokalassignment.data.repository.AppRepository
import com.example.lokalassignment.data.repository.AppRepositoryImpl
import com.example.lokalassignment.data.source.local.JobDao
import com.example.lokalassignment.data.source.remote.AppApiService
import com.example.lokalassignment.di.DatabaseProvider.provideDao
import com.example.lokalassignment.di.DatabaseProvider.provideDatabase
import com.example.lokalassignment.di.NetworkProvider.provideHttpClient
import com.example.lokalassignment.presentation.ui.screens.bookmarks_screen.BookmarkViewModel
import com.example.lokalassignment.presentation.ui.screens.job_screen.JobsViewModel
import com.example.lokalassignment.presentation.ui.screens.jobs_details_screen.JobsDetailsViewModel
import com.example.lokalassignment.presentation.ui.screens.shared_view_model.SharedJobViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Network
    single { provideHttpClient() }
    single { AppApiService(get()) }

    // Database
    single { provideDatabase(androidContext()) }
    single<JobDao> { provideDao(get()) }

    // Repository
    single<AppRepository> { AppRepositoryImpl(get(), get()) }

    // ViewModels
    viewModel { SharedJobViewModel() }
    viewModel { JobsViewModel(get()) }
    viewModel { BookmarkViewModel(get()) }
    viewModel { JobsDetailsViewModel(get()) }
}

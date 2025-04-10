package com.example.lokalassignment.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lokalassignment.data.mappers.toJobEntity
import com.example.lokalassignment.presentation.ui.screens.bookmarks_screen.BookmarkScreen
import com.example.lokalassignment.presentation.ui.screens.bookmarks_screen.BookmarkViewModel
import com.example.lokalassignment.presentation.ui.screens.job_screen.JobsScreen
import com.example.lokalassignment.presentation.ui.screens.job_screen.JobsViewModel
import com.example.lokalassignment.presentation.ui.screens.jobs_details_screen.JobDetailsScreen
import com.example.lokalassignment.presentation.ui.screens.jobs_details_screen.JobsDetailsViewModel
import com.example.lokalassignment.presentation.ui.screens.shared_view_model.SharedJobViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun DashboardNavHost(
    innerPadding: PaddingValues,
    rootNavController: NavHostController,
    startDestination: String = DashboardNavigation.Jobs.route,
) {

    val context = LocalContext.current

    val sharedViewModel: SharedJobViewModel = koinViewModel()

    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = rootNavController,
        startDestination = startDestination
    ) {

        composable(DashboardNavigation.Jobs.route) {

            val jobViewModel: JobsViewModel = koinViewModel()
            val jobsListState by jobViewModel.jobsListState.collectAsStateWithLifecycle()

            JobsScreen(jobsListState, onLoadMore = {
                jobViewModel.loadJobsList()
            }
            ) { job ->
                sharedViewModel.setJob(job.toJobEntity())
                rootNavController.navigate(DashboardNavigation.JobDetails.route)
            }
        }

        composable(DashboardNavigation.Bookmarks.route) {

            val bookmarkViewModel: BookmarkViewModel = koinViewModel()
            val bookmarkJobs by bookmarkViewModel.bookmarkedJobs.collectAsStateWithLifecycle()

            BookmarkScreen(bookmarkJobs) {
                sharedViewModel.setJob(it)
                rootNavController.navigate(DashboardNavigation.JobDetails.route)
            }
        }

        composable(DashboardNavigation.JobDetails.route) {

            val job by sharedViewModel.selectedJob.collectAsState()

            val jobsDetailsViewModel: JobsDetailsViewModel = koinViewModel()
            val isBookMarked = jobsDetailsViewModel.isBookmarked.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                jobsDetailsViewModel.isBookMarked(job!!)
            }

            JobDetailsScreen(isBookMarked, job!!) {
                jobsDetailsViewModel.toggleBookmark(it)
            }
        }

    }
}
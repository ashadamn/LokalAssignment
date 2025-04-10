package com.example.lokalassignment.presentation.navigation

sealed class DashboardNavigation(val route: String) {

    data object Jobs : DashboardNavigation("jobs_screen")

    data object Bookmarks : DashboardNavigation("bookmarks_screen")

    data object JobDetails : DashboardNavigation("job_details_screen")
}
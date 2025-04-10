package com.example.lokalassignment.presentation.navigation

import com.example.lokalassignment.R


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
)

val items = listOf(
    BottomNavigationItem(
        title = "jobs_screen",
        selectedIcon = R.drawable.jobs_selected_ic,
        unSelectedIcon = R.drawable.jobs_unselected_ic
    ),
    BottomNavigationItem(
        title = "bookmarks_screen",
        selectedIcon = R.drawable.bookmark_selected_ic,
        unSelectedIcon = R.drawable.bookmark_unselected_ic
    )
)
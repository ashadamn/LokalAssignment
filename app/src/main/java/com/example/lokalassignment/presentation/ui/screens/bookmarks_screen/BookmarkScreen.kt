package com.example.lokalassignment.presentation.ui.screens.bookmarks_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lokalassignment.data.source.local.JobEntity
import com.example.lokalassignment.presentation.theme.Spacing
import com.example.lokalassignment.presentation.ui.common_components.JobItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkScreen(
    bookmarkJobs: List<JobEntity>,
    onClick: (JobEntity) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
                title = { Text(text = "Bookmark List") }
            )
        },
        content = { padding ->

            if (bookmarkJobs.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "No bookmarks found")
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = padding.calculateTopPadding()),
                    contentPadding = PaddingValues(Spacing.medium)
                ) {
                    items(bookmarkJobs) { job ->
                        JobItem(job) {
                            onClick.invoke(job)
                        }
                    }
                }
            }
        }
    )
}

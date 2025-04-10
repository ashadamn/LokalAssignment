package com.example.lokalassignment.presentation.ui.screens.jobs_details_screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.lokalassignment.R
import com.example.lokalassignment.data.source.local.JobEntity
import com.example.lokalassignment.presentation.theme.Spacing
import com.example.lokalassignment.util.showToast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailsScreen(
    isBookMarked: State<Boolean>,
    job: JobEntity,
    onBookmarkClick: (JobEntity) -> Unit,
) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp),
                title = { Text(text = "Jobs Details") }
            )
        },
        content = { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = padding.calculateTopPadding())
                    .padding(horizontal = Spacing.medium)
                    .verticalScroll(rememberScrollState())
            ) {

                if (job.otherDetails.isNotBlank()) {
                    Text(
                        modifier = Modifier
                            .padding(Spacing.medium),
                        text = job.otherDetails.replace(
                            "\r\n",
                            "\n\n"
                        ),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                } else {
                    Text(
                        modifier = Modifier
                            .padding(Spacing.medium),
                        text = "No Description Available",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                Row(
                    modifier = Modifier
                        .padding(Spacing.large)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Button(
                        modifier = Modifier
                            .weight(1f),
                        onClick = {
                            if (job.customLink.isNotBlank() || job.customLink == "Null") {
                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = Uri.parse(job.customLink)
                                }
                                context.startActivity(intent)
                            } else {
                                context.showToast("Phone number not available")
                            }
                        }) {
                        Text("Call HR")
                    }

                    Image(
                        modifier = Modifier
                            .size(40.dp)
                            .clickable { onBookmarkClick.invoke(job) },
                        painter = painterResource(
                            id = if (isBookMarked.value)
                                R.drawable.bookmark_filled else
                                R.drawable.bookmark_unfilled
                        ),
                        contentDescription = null
                    )
                }

            }

        }
    )
}
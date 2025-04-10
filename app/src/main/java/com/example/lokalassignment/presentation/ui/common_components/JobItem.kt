package com.example.lokalassignment.presentation.ui.common_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.lokalassignment.data.source.local.JobEntity
import com.example.lokalassignment.presentation.theme.Spacing

@Composable
fun JobItem(
    job: JobEntity,
    onClick: () -> Unit,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing.medium)
            .height(110.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = Spacing.small),
        onClick = { onClick.invoke() }
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing.medium),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Title - ${job.title}",
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                modifier = Modifier
                    .padding(top = Spacing.small),
                text = "Location - ${job.location}",
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = "Salary - ${job.salary}",
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = "Phone - ${job.phone}",
                style = MaterialTheme.typography.titleSmall
            )

        }

    }

}
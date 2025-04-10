package com.example.lokalassignment.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lokalassignment.presentation.navigation.DashboardNavHost
import com.example.lokalassignment.presentation.navigation.items
import com.example.lokalassignment.presentation.theme.LokalAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LokalAssignmentTheme {
                val rootNavController = rememberNavController()
                val navBackStackEntry by rootNavController.currentBackStackEntryAsState()

                Scaffold(bottomBar = {
                    NavigationBar(
                        modifier = Modifier
                            .fillMaxWidth(),
                        windowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        items.forEach { item ->
                            val isSelected =
                                item.title.lowercase() == navBackStackEntry?.destination?.route
                            NavigationBarItem(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                selected = isSelected,
                                onClick = {
                                    rootNavController.navigate(item.title.lowercase()) {
                                        popUpTo(rootNavController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = {
                                    Text(text = if (item.title == "jobs_screen") "Jobs" else "Bookmarks")
                                },
                                icon = {
                                    Image(
                                        painter = painterResource(
                                            id = if (isSelected)
                                                item.selectedIcon
                                            else
                                                item.unSelectedIcon
                                        ),
                                        contentDescription = "nav_icon",
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = Color.Transparent
                                )
                            )
                        }
                    }
                }
                ) { innerPadding ->
                    DashboardNavHost(innerPadding, rootNavController)
                }
            }
        }
    }
}


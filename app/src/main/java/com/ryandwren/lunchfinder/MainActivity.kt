package com.ryandwren.lunchfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ryandwren.lunchfinder.ui.ListScreen
import com.ryandwren.lunchfinder.ui.MapScreen
import com.ryandwren.lunchfinder.ui.theme.LunchFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LunchFinderTheme {

                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    topBar = {},
                    bottomBar = {
                        HorizontalDivider()

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {

                            Row(
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ScreenNames.LIST)
                                    }
                                    .padding(vertical = 16.dp, horizontal = 48.dp)
                            ) {
                                Text(
                                    text = "List"
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(ScreenNames.MAP)
                                    }
                                    .padding(vertical = 16.dp, horizontal = 48.dp)
                            ) {
                                Text(
                                    text = "Map"
                                )
                            }
                        }
                    },
                )
                { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = ScreenNames.LIST,
                        Modifier.padding(innerPadding)
                    ) {
                        composable(ScreenNames.LIST) {
                            ListScreen()
                        }

                        composable(ScreenNames.MAP) {
                            MapScreen()
                        }
                    }
                }
            }
        }
    }
}

object ScreenNames {
    const val LIST = "List"
    const val MAP = "Map"
}

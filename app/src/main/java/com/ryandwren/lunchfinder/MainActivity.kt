package com.ryandwren.lunchfinder

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
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
                    CheckAndRequestLocationPermission()

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

@Composable
fun CheckAndRequestLocationPermission() {
    val requestLocationPermissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) {}
    val context = LocalContext.current

    SideEffect {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestLocationPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }
}

package com.ryandwren.lunchfinder.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen(){
    Box(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        contentAlignment = Alignment.Center
    ){
        Text("List")
    }
}
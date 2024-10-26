package com.ryandwren.lunchfinder.ui

import androidx.compose.runtime.mutableStateOf
import com.ryandwren.lunchfinder.data.PlaceResponseObject

class LunchState {
    val isRequestInProgress = mutableStateOf(false)

    val restaurantsList = mutableStateOf(emptyList<PlaceResponseObject.Results>())
}
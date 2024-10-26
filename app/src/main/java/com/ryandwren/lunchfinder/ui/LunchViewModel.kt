package com.ryandwren.lunchfinder.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ryandwren.lunchfinder.data.repositories.PlacesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LunchViewModel @Inject constructor(
    private val placesRepository: PlacesRepository
): ViewModel() {
    val state = LunchState()

    init {
        getRestaurantsList()
    }

    private fun getRestaurantsList(){
        viewModelScope.launch {
            placesRepository.getNearbyPlaces(
                lat = "-33.8670522",
                long = "151.1957362",
                radius = 1500,
                type = "restaurant"
            )
                .onStart { state.isRequestInProgress.value = true }
                .onCompletion { state.isRequestInProgress.value = false }
                .collect {
                    state.restaurantsList.value = it.results
                }
        }
    }
}
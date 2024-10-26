package com.ryandwren.lunchfinder.data.repositories

import com.ryandwren.lunchfinder.data.PlaceResponseObject
import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    suspend fun getNearbyPlaces(lat: String, long: String, radius: Int, type: String, keyword: String? = null): Flow<PlaceResponseObject>
}
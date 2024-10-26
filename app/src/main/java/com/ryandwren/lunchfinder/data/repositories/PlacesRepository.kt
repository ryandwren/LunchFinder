package com.ryandwren.lunchfinder.data.repositories

interface PlacesRepository {
    suspend fun getNearbyPlaces()
}
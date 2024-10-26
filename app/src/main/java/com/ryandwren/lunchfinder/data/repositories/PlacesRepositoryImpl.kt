package com.ryandwren.lunchfinder.data.repositories

import com.ryandwren.lunchfinder.data.PlacesAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesRepositoryImpl @Inject constructor(
    private val api: PlacesAPI
): PlacesRepository{
    override suspend fun getNearbyPlaces() {
        TODO("Not yet implemented")
    }
}
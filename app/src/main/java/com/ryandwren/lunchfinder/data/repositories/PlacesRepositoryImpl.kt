package com.ryandwren.lunchfinder.data.repositories

import com.ryandwren.lunchfinder.data.PlaceResponseObject
import com.ryandwren.lunchfinder.data.PlacesAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlacesRepositoryImpl @Inject constructor(
    private val api: PlacesAPI
): PlacesRepository{
    override suspend fun getNearbyPlaces(
        lat: String,
        long: String,
        radius: Int,
        type: String,
        keyword: String?
    ): Flow<PlaceResponseObject> {
        return flow {
            emit(
                api.getNearbyPlaces(
                    mapOf(
                        "location" to "$lat,$long",
                        "radius" to radius.toString(),
                        "type" to type,
                        "keyword" to (keyword ?: "")
                    )
                )
            )
        }
    }
}
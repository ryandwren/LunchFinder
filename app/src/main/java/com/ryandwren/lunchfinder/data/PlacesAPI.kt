package com.ryandwren.lunchfinder.data

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface PlacesAPI {

    @GET("nearbysearch/json")
    @Headers("Content-Type: application/json")
    suspend fun getNearbyPlaces(
        @QueryMap params: Map<String, String>
    ): PlaceResponseObject
}
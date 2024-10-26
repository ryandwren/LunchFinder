package com.ryandwren.lunchfinder.data

import com.ryandwren.lunchfinder.data.repositories.PlacesRepository
import com.ryandwren.lunchfinder.data.repositories.PlacesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASEURL = "https://maps.googleapis.com/maps/api/place"

    @Provides
    @Singleton
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor()) //Inject API key into headers.
                    .build()
            )
    }

    @Provides
    @Singleton
    fun providePlacesApi(retrofit: Retrofit.Builder): PlacesAPI {
        return retrofit
            .baseUrl(BASEURL)
            .build()
            .create(PlacesAPI::class.java)
    }

    @Provides
    @Singleton
    fun providePlacesRepository(api: PlacesAPI): PlacesRepository{
        return PlacesRepositoryImpl(api)
    }
}
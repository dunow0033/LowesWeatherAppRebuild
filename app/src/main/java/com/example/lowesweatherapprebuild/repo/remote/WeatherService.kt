package com.example.lowesweatherapprebuild.repo.remote

import com.example.lowesweatherapprebuild.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeatherForCity
}
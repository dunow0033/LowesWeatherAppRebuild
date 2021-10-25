package com.example.lowesweatherapprebuild.repo

import com.example.lowesweatherapprebuild.repo.remote.RetrofitInstance
import com.example.lowesweatherapprebuild.util.State
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object WeatherRepo {

    fun getWeatherResponse(city: String) = flow {
        emit(State.Loading)
        val state = try {
            val response = RetrofitInstance.weatherService
        }
    }
}
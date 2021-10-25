package com.example.lowesweatherapprebuild.viewmodel

import androidx.lifecycle.*
import com.example.lowesweatherapprebuild.model.HourlyWeather
import com.example.lowesweatherapprebuild.repo.WeatherRepo
import com.example.lowesweatherapprebuild.util.State

class WeatherSearchViewModel : ViewModel() {

    private val cityQuery = MutableLiveData<String>()
    private val hasNavigatedLd = MutableLiveData<Boolean>()

    val state: LiveData<State<List<HourlyWeather>>> =
        MediatorLiveData<State<List<HourlyWeather>>>().apply {
            addSource(hasNavigatedLd) {
                if(it) {
                    value = State.NoAction
                    hasNavigated = false
                }
            }
            addSource(cityQuery) {
                addSource(WeatherRepo.)
            }
        }
}
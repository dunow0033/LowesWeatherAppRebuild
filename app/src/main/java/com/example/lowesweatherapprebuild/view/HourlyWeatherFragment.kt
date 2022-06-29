package com.example.lowesweatherapprebuild.view

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.solver.state.State
import com.example.lowesweatherapprebuild.adapter.WeatherAdapter
import kotlinx.coroutines.selects.SelectInstance

class HourlyWeatherFragment : Fragment(R.layout.fragment_hourly_weather) {

    private val arguments: HourlyWeatherFragmentArgs by navArgs()

    private val weatherAdapter by lazy {
        WeatherAdapter(arguments.myWeather.toList(), this::onWeatherSelected)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle) {
        super.onViewCreated(view, savedInstanceState)
        with
    }
}
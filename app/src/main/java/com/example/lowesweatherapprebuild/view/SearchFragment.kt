package com.example.lowesweatherapprebuild.view

import com.example.lowesweatherapp.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lowesweatherapprebuild.databinding.FragmentLookupBinding
import com.example.lowesweatherapprebuild.util.State
import com.example.lowesweatherapprebuild.viewmodel.WeatherSearchViewModel

class SearchFragment : Fragment(R.layout.fragment_lookup){

    private val viewModel: WeatherSearchViewModel by viewModels()
    private lateinit var binding: FragmentLookupBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLookupBinding.bind(view).apply {
            btnSearch.setOnClickListener {
                viewModel.query = etCity.text.toString()
            }
        }
        with(viewModel) {
            state.observe(viewLifecycleOwner) {
                if(it is State.Success) navigateToWeatherList(query, it.data.toTypedArray())
                with(binding.textFieldLayout) {

                }
            }
        }
    }
}
package com.example.lowesweatherapprebuild.view

import androidx.core.view.isVisible
import com.example.lowesweatherapp.R
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapprebuild.databinding.FragmentLookupBinding
import com.example.lowesweatherapprebuild.model.HourlyWeather
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
//        with(viewModel) {
//            viewModel.observe(viewLifecycleOwner) {
//                if(it is State.Success) navigateToWeatherList(query, it.data.toTypedArray())
//                with(binding.textFieldLayout) {
//                    isErrorEnabled = if(it is State.Error) {
//                        error = it.errMsg;true
//                    } else false
//                }
//                binding.progressBar.isVisible = it is State.Loading
//                binding.btnSearch.isEnabled = it !is State.Loading
//            }
//        }
        viewModel.state.observe(viewLifecycleOwner){
            if(binding.textFieldLayout is State.Success)
                navigateToWeatherList(query, binding.textFieldLayout.data.toTypedArray())
            isErrorEnabled = if(binding.textFieldLayout is State.Error) {
                error = binding.textFieldLayout.errMsg;
                true
            } else false
            binding.progressBar.isVisible = binding.textFieldLayout is State.Loading
            binding.progressBar.isEnabled = binding.textFieldLayout !is State.Loading
        }

        private fun navigateToWeatherList(
            city: String,
            data: Array<HourlyWeather>
        ) {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToHourlyWeatherFragment(
                    data,
                    city
                )
            )
            viewModel.hasNavigated = true
    }
}
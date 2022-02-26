package com.example.sharedpreferenceexample.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sharedpreferenceexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        val sharedPreference = this.requireActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE)
        homeViewModel.get(sharedPreference)

        val textView: TextView = binding.title
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        binding.button.setOnClickListener{
            sharedPreference.edit().apply{
                putString("NOTIFY",  binding.notificationTx.text.toString())
                putString("DASH", binding.dashboardTx.text.toString())
            }.apply()
        }

        binding.buttonRt.setOnClickListener {
            sharedPreference.edit().clear().apply()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
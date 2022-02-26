package com.example.sharedpreferenceexample.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sharedpreferenceexample.R
import com.example.sharedpreferenceexample.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private lateinit var sharedPreferences: SharedPreferences

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.startBt.setOnClickListener {
           saveProgress()
       }

    }

    override fun onStart() {
        super.onStart()
        if (completed()){
            findNavController().navigate(R.id.action_splash_to_navigation_home)
        }
    }

    private fun saveProgress(){
        sharedPreferences = this.requireActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean("DONE", true )
        }.apply()
        findNavController().navigate(R.id.action_splash_to_navigation_home)
    }

    private fun completed(): Boolean {
        sharedPreferences =
            this.requireActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("DONE", false)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
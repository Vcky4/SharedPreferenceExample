package com.example.sharedpreferenceexample.ui.dashboard

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun get(sharedPreferences: SharedPreferences){
        _text.value = sharedPreferences.getString("DASH", "Nothing yet")
    }
}
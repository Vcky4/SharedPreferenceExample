package com.example.sharedpreferenceexample.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun get(sharedPreferences: SharedPreferences){
        val text = sharedPreferences.getBoolean("DONE", false)
        _text.value = text.toString()
    }
}
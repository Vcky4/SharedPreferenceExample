package com.example.sharedpreferenceexample.ui.notifications

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun get(sharedPreferences: SharedPreferences){
        _text.value = sharedPreferences.getString("NOTIFY", "Nothing yet")
    }
}
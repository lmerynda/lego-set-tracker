package com.example.legosettracker.ui.singleset

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.legosettracker.LegoSetsStorage

class SingleSetViewModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val legoSetsStorage = LegoSetsStorage(sharedPreferences)
        return SingleSetViewModel(legoSetsStorage) as T
    }
}
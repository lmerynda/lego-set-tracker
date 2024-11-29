package com.example.legosettracker.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.legosettracker.LegoSetsStorage

class HomeViewModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val legoSetsStorage = LegoSetsStorage(sharedPreferences)
        return HomeViewModel(legoSetsStorage) as T
    }
}
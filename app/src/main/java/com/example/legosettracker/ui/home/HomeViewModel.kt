package com.example.legosettracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.LegoSet
import com.example.legosettracker.LegoSetItem
import com.example.legosettracker.LegoSetsData

class HomeViewModel : ViewModel() {
    val title: String = "All Lego Sets"

    private val _legoSets = MutableLiveData<List<LegoSet>>().apply {
        value = LegoSetsData.legoSets
    }
    val legoSets: LiveData<List<LegoSet>> get() = _legoSets
}
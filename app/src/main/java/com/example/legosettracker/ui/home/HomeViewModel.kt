package com.example.legosettracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.LegoSet
import com.example.legosettracker.LegoSetsStorage

class HomeViewModel(private val legoSetsStorage: LegoSetsStorage) : ViewModel() {
    val title: String = "All Lego Sets"

    private val _legoSets = MutableLiveData<List<LegoSet>>()
    val legoSets: LiveData<List<LegoSet>> get() = _legoSets

    init {
        loadLegoSets()
    }

    private fun loadLegoSets() {
        _legoSets.value = legoSetsStorage.getLegoSets()
    }
}
package com.example.legosettracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.ui.singleset.LegoSet
import com.example.legosettracker.ui.singleset.LegoSetItem

class HomeViewModel : ViewModel() {
    val title: String = "All Lego Sets"

    private val set1 = LegoSet("Lego Set 1", listOf(LegoSetItem("Brick 1", 10), LegoSetItem("Brick 2", 20)))
    private val set2 = LegoSet("Lego Set 2", listOf(LegoSetItem("Brick 1", 30), LegoSetItem("Brick 3", 40)))
    private val set3 = LegoSet("Lego Set 3", listOf(LegoSetItem("Brick 2", 50), LegoSetItem("Brick 3", 60)))

    private val _legoSets = MutableLiveData<List<LegoSet>>().apply {
        value = listOf(set1, set2, set3)
    }
    val legoSets: LiveData<List<LegoSet>> get() = _legoSets
}
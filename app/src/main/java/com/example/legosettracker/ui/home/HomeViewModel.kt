package com.example.legosettracker.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.ui.singleset.SingleSet
import com.example.legosettracker.ui.singleset.SingleSetItem

class HomeViewModel : ViewModel() {
    val title: String = "All Lego Sets"

    private val set1 = SingleSet("Lego Set 1", listOf(SingleSetItem("Brick 1", 10), SingleSetItem("Brick 2", 20)))
    private val set2 = SingleSet("Lego Set 2", listOf(SingleSetItem("Brick 1", 30), SingleSetItem("Brick 3", 40)))
    private val set3 = SingleSet("Lego Set 3", listOf(SingleSetItem("Brick 2", 50), SingleSetItem("Brick 3", 60)))

    private val _legoSets = MutableLiveData<List<SingleSet>>().apply {
        value = listOf(set1, set2, set3)
    }
    val legoSets: LiveData<List<SingleSet>> get() = _legoSets
}
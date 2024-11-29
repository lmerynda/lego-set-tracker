package com.example.legosettracker.ui.singleset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.LegoSetItem
import com.example.legosettracker.LegoSetsStorage

class SingleSetViewModel(private val legoSetsStorage: LegoSetsStorage) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is LegoSet Fragment"
    }
    val text: LiveData<String> = _text

    private val _items = MutableLiveData<List<LegoSetItem>>()
    val items: LiveData<List<LegoSetItem>> get() = _items

    fun setSingeSet(legoSetId: String) {
        legoSetsStorage.getLegoSetByTitle(legoSetId)?.let { legoSet ->
            _items.value = legoSet.items
            _text.value = legoSet.title
        }
    }

    fun saveLegoSet() {
        val legoSetId = _text.value ?: return

        legoSetsStorage.getLegoSetByTitle(legoSetId)?.let { legoSet ->
            val updatedLegoSet = legoSet.copy(items = _items.value ?: emptyList())
            legoSetsStorage.saveLegoSet(updatedLegoSet)
        }
    }
}
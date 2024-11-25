package com.example.legosettracker.ui.singleset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.legosettracker.LegoSetItem

class SingleSetViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is LegoSet Fragment"
    }
    val text: LiveData<String> = _text

    private val _items = MutableLiveData<List<LegoSetItem>>()
    val items: LiveData<List<LegoSetItem>> get() = _items

}
package com.example.legosettracker.ui.singleset

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SingleSetViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is LegoSet Fragment"
    }
    val text: LiveData<String> = _text

    private val _items = MutableLiveData<List<SingleSetItem>>()
    val items: LiveData<List<SingleSetItem>> get() = _items

}
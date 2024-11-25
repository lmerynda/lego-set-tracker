package com.example.legosettracker.ui.singleset

data class SingleSetItem(val title: String, val count: Int) {
    val countString: String = count.toString()
}
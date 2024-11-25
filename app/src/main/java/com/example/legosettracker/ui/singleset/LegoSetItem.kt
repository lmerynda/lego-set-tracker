package com.example.legosettracker.ui.singleset

data class LegoSetItem(val brickName: String, val count: Int) {
    val countString: String = count.toString()
}
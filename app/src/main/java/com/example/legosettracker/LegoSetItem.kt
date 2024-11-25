package com.example.legosettracker

data class LegoSetItem(val brickName: String, val count: Int) {
    val countString: String = count.toString()
}
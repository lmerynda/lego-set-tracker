package com.example.legosettracker

data class LegoSetItem(val brickName: String, val totalCount: Int, val bricksCollected: Int) {
    val countString: String = totalCount.toString()
}
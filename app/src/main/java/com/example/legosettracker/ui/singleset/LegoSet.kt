package com.example.legosettracker.ui.singleset

data class LegoSet(
    val title: String,
    val items: List<LegoSetItem>
){
    fun getBricksCount(): Int {
        return items.sumOf { it.count }
    }

}
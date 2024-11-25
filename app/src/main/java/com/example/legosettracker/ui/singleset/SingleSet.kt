package com.example.legosettracker.ui.singleset

data class SingleSet(
    val title: String,
    val items: List<SingleSetItem>
){
    fun getBricksCount(): Int {
        return items.sumOf { it.count }
    }

}
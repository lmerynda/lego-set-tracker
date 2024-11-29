package com.example.legosettracker

data class LegoSet(
    val title: String,
    var items: List<LegoSetItem>
){
    fun getBricksCount(): Int {
        return items.sumOf { it.totalCount }
    }

}
package com.example.legosettracker

class LegoSetsData {
    companion object {
        val legoSets: List<LegoSet> = listOf(
            LegoSet(
                "Bonsai Tree",
                listOf(
                    LegoSetItem("Brick 1", 10, 5),
                    LegoSetItem("Brick 2", 20, 5),
                    LegoSetItem("Brick 3", 30,0),
                    LegoSetItem("Brick 4", 40,0),
                    LegoSetItem("Brick 5", 50,0),
                    LegoSetItem("Brick 6", 60,0),
                    LegoSetItem("Brick 7", 70,0),
                    LegoSetItem("Brick 8", 80,0),
                    LegoSetItem("Brick 9", 90,0),
                    LegoSetItem("Brick 10", 100,0)
                )
            ),
            LegoSet(
                "Sesame Street",
                listOf(
                    LegoSetItem("Brick 1", 1,0),
                    LegoSetItem("Brick 2", 2,0),
                    LegoSetItem("Brick 3", 3,0),
                    LegoSetItem("Brick 4", 4,0),
                    LegoSetItem("Brick 5", 5,0),
                    LegoSetItem("Brick 6", 6,0),
                    LegoSetItem("Brick 7", 7,0),
                    LegoSetItem("Brick 8", 8,0),
                    LegoSetItem("Brick 9", 9,0),
                    LegoSetItem("Brick 10", 10,0)
                )
            ),
            LegoSet(
                "Ford Anglia",
                listOf(
                    LegoSetItem("Brick 1", 5,0),
                    LegoSetItem("Brick 2", 10,0),
                    LegoSetItem("Brick 3", 15,0),
                    LegoSetItem("Brick 4", 20,0),
                    LegoSetItem("Brick 5", 25,0),
                    LegoSetItem("Brick 6", 30,0),
                    LegoSetItem("Brick 7", 35,0),
                    LegoSetItem("Brick 8", 40,0),
                    LegoSetItem("Brick 9", 45,0),
                    LegoSetItem("Brick 10", 50,0)
                )
            )
        )
    }
}
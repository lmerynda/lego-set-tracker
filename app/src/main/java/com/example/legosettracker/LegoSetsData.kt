package com.example.legosettracker

class LegoSetsData {
    companion object {
        val legoSets: List<LegoSet> = listOf(
            LegoSet(
                "Bonsai Tree",
                listOf(
                    LegoSetItem("Brick 1", 10),
                    LegoSetItem("Brick 2", 20),
                    LegoSetItem("Brick 3", 30),
                    LegoSetItem("Brick 4", 40),
                    LegoSetItem("Brick 5", 50),
                    LegoSetItem("Brick 6", 60),
                    LegoSetItem("Brick 7", 70),
                    LegoSetItem("Brick 8", 80),
                    LegoSetItem("Brick 9", 90),
                    LegoSetItem("Brick 10", 100)
                )
            ),
            LegoSet(
                "Sesame Street",
                listOf(
                    LegoSetItem("Brick 1", 1),
                    LegoSetItem("Brick 2", 2),
                    LegoSetItem("Brick 3", 3),
                    LegoSetItem("Brick 4", 4),
                    LegoSetItem("Brick 5", 5),
                    LegoSetItem("Brick 6", 6),
                    LegoSetItem("Brick 7", 7),
                    LegoSetItem("Brick 8", 8),
                    LegoSetItem("Brick 9", 9),
                    LegoSetItem("Brick 10", 10)
                )
            ),
            LegoSet(
                "Ford Anglia",
                listOf(
                    LegoSetItem("Brick 1", 5),
                    LegoSetItem("Brick 2", 10),
                    LegoSetItem("Brick 3", 15),
                    LegoSetItem("Brick 4", 20),
                    LegoSetItem("Brick 5", 25),
                    LegoSetItem("Brick 6", 30),
                    LegoSetItem("Brick 7", 35),
                    LegoSetItem("Brick 8", 40),
                    LegoSetItem("Brick 9", 45),
                    LegoSetItem("Brick 10", 50)
                )
            )
        )
    }
}
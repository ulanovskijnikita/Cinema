package com.example.cinema

data class CardData(val cardImg:Int)
class CardList {
    val cList= listOf(CardData(R.drawable.card1),
        CardData(R.drawable.card2),
        CardData(R.drawable.card3),
        CardData(R.drawable.card4),
        CardData(R.drawable.card5))
}

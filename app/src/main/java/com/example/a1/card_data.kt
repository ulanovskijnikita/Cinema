package com.example.a1

data class card_data(val img_card:Int)
class card_list {
    val c_list= listOf(card_data(R.drawable.card1),
        card_data(R.drawable.card2),
        card_data(R.drawable.card3),
        card_data(R.drawable.card4),
        card_data(R.drawable.card5))
}

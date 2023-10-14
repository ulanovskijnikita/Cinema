package com.example.cinema

data class fragment_data(val img_frament:Int, val text_frament:String)
class fragment_list {
    val f_list= listOf(fragment_data(R.drawable.films_avatar, "ГГшка рожает детей, но потом\nприходят люди и\nначинается охота!"),
        fragment_data(R.drawable.films_wednesday, "Семейка Аддамс в\nреальном мире!\nВенсдей звезда действа!"),
        fragment_data(R.drawable.films_emily, "Какая-то Эмили?\nНаверное интересно\nПосмотрите и расскажите!"))
}

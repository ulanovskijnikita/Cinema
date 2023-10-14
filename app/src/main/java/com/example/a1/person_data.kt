package com.example.a1

data class person_data(val img_person:Int, val name_person:String, val text_person:String)
class person_list {
    val p_list= listOf(person_data(R.drawable.happy_harley, "Счастливая Харли", "Харли в начале отношений\nс Джокером"),
        person_data(R.drawable.brutal_harley, "Брутальная Харли", "Харли на Деле\nс Джокером"),
        person_data(R.drawable.mocking_harley, "Насмешливая Харли", "Харли в маниакальной фазе"),
        person_data(R.drawable.sad_harley, "Грустная Харли" , "Харли расталась\nс Джокером"),
        person_data(R.drawable.thoughtful_halrey, "Задумчивая Харли", "Харли думает:\nкак жить дальше?"))
}

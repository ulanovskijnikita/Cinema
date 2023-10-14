package com.example.cinema

data class person_data(val img_person:Int, val name_person:String, val text_person:String)
class person_list {
    val p_list= listOf(person_data(R.drawable.person_mardot_robbie, "Марго Робби", "Марго Робби (род.\n2 июля 1990) —\nавстралийская актриса и\nпродюсер. Известна по ролям\nв блокбастерах и\nнезависимых фильмах"),
        person_data(R.drawable.person_jerny_smollett, "Джерни Смоллетт", "Джерни Смоллетт (род.\n1 октября 1986) —\nамериканская актриса.\nИзвестность и признание\nкритиков пришли после\nпоявления на экранах драмы\n«Пристанище Евы»"),
        person_data(R.drawable.person_mary_elizabeth_winstead, "Мэри Элизабет Уинстэд", "Мэри Элизабет Уинстэд (род.\n28 ноября 1984) —\nамериканская актриса\nи певица. Известна прежде\nвсего как «королева крика»"),
        person_data(R.drawable.person_rosie_perez, "Рози Перес" , "Рози Перес (род.\n6 сентября 1964) —\nамериканская актриса,\nхореограф, режиссёр\nи общественный деятель.\nБыла номинирована\nна кинопремию «Оскар»"),
        person_data(R.drawable.person_ella_j_basco, "Элла Джей Баско", "Элла Джей Баско (род.\n17 сентября\n2006) — американская певица,\nкиноактриса. Она сыграла\nэпизодические роли\nв фильмах: «Анатомия\nстрасти», «Хэппиленд»..."))
}

package com.example.cinema.retrofit.model

data class Data(val success:Boolean, val data: List<DataMovie>)
data class DataMovie(val id:String, val title:String, val image:String)

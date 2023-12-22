package com.example.cinema.db

import android.provider.BaseColumns

object RegDbName {
    const val TABLE_NAME = "USER_DATA"
    const val COLUMN_NAME_NAME = "NAME"
    const val COLUMN_NAME_FAMILY = "FAMILY"
    const val COLUMN_NAME_MAIL = "MAIL"
    const val COLUMN_NAME_PASS = "PASS"

    const val CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COLUMN_NAME_NAME TEXT," +
                "$COLUMN_NAME_FAMILY TEXT," +
                "$COLUMN_NAME_MAIL TEXT," +
                "$COLUMN_NAME_PASS TEXT)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}
package com.example.cinema.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class regDbHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(regDbName.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(regDbName.DELETE_TABLE)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 4
        const val DATABASE_NAME = "CinemaDb.db"
    }
}
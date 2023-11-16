package com.example.cinema.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RegDbHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(RegDbName.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(RegDbName.DELETE_TABLE)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 5
        const val DATABASE_NAME = "CinemaDb.db"
    }
}
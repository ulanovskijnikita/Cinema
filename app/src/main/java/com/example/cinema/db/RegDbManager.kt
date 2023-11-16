package com.example.cinema.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class RegDbManager(context: Context) {
    private val regDbHelper = RegDbHelper(context)
    private lateinit var db: SQLiteDatabase

//    var itemAll = arrayListOf<String>()
    private var itemMail = arrayListOf<String>()
    private lateinit var itemPass: String
    private lateinit var itemName: String
    fun insertToDb(name: String, family: String, mail: String, pass: String) {
        db = regDbHelper.writableDatabase

        val values = ContentValues().apply {
            put(RegDbName.COLUMN_NAME_NAME, name)
            put(RegDbName.COLUMN_NAME_FAMILY, family)
            put(RegDbName.COLUMN_NAME_MAIL, mail)
            put(RegDbName.COLUMN_NAME_PASS, pass)
        }
        db.insert(RegDbName.TABLE_NAME, null, values)
    }

//    fun readDbDataAll(): ArrayList<String> {
//        db = regDbHelper.readableDatabase
//        val projection = arrayOf(regDbName.COLUMN_NAME_NAME, regDbName.COLUMN_NAME_FAMILY, regDbName.COLUMN_NAME_MAIL, regDbName.COLUMN_NAME_PASS)
//        val cursor = db.query(regDbName.TABLE_NAME, projection, null, null, null, null, null)
//
//        with(cursor) {
//            while (moveToNext()) {
//                val itemId = getString(getColumnIndexOrThrow(regDbName.COLUMN_NAME_NAME)) + " "+
//                        getString(getColumnIndexOrThrow(regDbName.COLUMN_NAME_FAMILY)) + " " +
//                        getString(getColumnIndexOrThrow(regDbName.COLUMN_NAME_MAIL)) + " " +
//                        getString(getColumnIndexOrThrow(regDbName.COLUMN_NAME_PASS))
//                itemAll.add(itemId)
//            }
//        }
//        cursor.close()
//        return itemAll
//    }

    fun readDbDataMail(): ArrayList<String> {
        db = regDbHelper.readableDatabase
        val projection = arrayOf(RegDbName.COLUMN_NAME_MAIL)
        val cursor = db.query(RegDbName.TABLE_NAME, projection, null, null, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                val itemId = getString(getColumnIndexOrThrow(RegDbName.COLUMN_NAME_MAIL))
                itemMail.add(itemId)
            }
        }
        cursor.close()
        return itemMail
    }

    fun readDbDataPassOfMail(mail: String): String {
        db = regDbHelper.readableDatabase
        val projection = arrayOf(RegDbName.COLUMN_NAME_MAIL, RegDbName.COLUMN_NAME_PASS)
        val selection = "${RegDbName.COLUMN_NAME_MAIL} = ?"
        val selectionArgs = arrayOf(mail)

        val cursor = db.query(RegDbName.TABLE_NAME, projection, selection, selectionArgs, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                itemPass = getString(getColumnIndexOrThrow(RegDbName.COLUMN_NAME_PASS))
            }
        }
        cursor.close()
        return itemPass
    }

    fun readDbDataNameOfMail(mail: String): String {
        db = regDbHelper.readableDatabase
        val projection = arrayOf(RegDbName.COLUMN_NAME_MAIL, RegDbName.COLUMN_NAME_NAME, RegDbName.COLUMN_NAME_FAMILY)
        val selection = "${RegDbName.COLUMN_NAME_MAIL} = ?"
        val selectionArgs = arrayOf(mail)

        val cursor = db.query(RegDbName.TABLE_NAME, projection, selection, selectionArgs, null, null, null)

        with(cursor) {
            while (moveToNext()) {
                itemName = getString(getColumnIndexOrThrow(RegDbName.COLUMN_NAME_NAME)) + " " +
                        getString(getColumnIndexOrThrow(RegDbName.COLUMN_NAME_FAMILY))
            }
        }
        cursor.close()
        return itemName
    }

    fun closeDb() {
        db.close()
    }
}
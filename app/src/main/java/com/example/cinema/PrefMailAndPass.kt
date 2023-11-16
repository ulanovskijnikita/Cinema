package com.example.cinema
import android.content.SharedPreferences
import android.widget.CheckBox
import android.widget.EditText

class PrefMailAndPass {

    lateinit var preffEmailAndPass: SharedPreferences

    lateinit var mail: EditText
    lateinit var pass: EditText
    lateinit var checkBox: CheckBox

    fun preffEmailAndPassSaveState(checkBox:Boolean) {
        val editor=preffEmailAndPass.edit()
        editor?.putBoolean("checkBox", checkBox)
        editor?.apply()
    }

    fun preffEmailAndPassSaveData(mail:String, pass:String) {
        val editor=preffEmailAndPass.edit()
        editor?.putString("mail", mail)
        editor?.putString("pass", pass)
        editor?.apply()
    }

    fun preffEmailAndPassDeleteAll() {
        val editor=preffEmailAndPass.edit()
        editor?.clear()
        editor?.apply()
    }

    fun preffEmailAndPassInsert() {
        val checkBoxState:Boolean=checkBox.isChecked

        if (checkBoxState == true) {
            val valueMail:String=mail.text.toString()
            val valuePass:String=pass.text.toString()

            preffEmailAndPassSaveData(valueMail, valuePass)
            preffEmailAndPassSaveState(checkBoxState)
        }
        else {
            preffEmailAndPassDeleteAll()
        }
    }
    fun preffEmailAndPassContains() {
        if (preffEmailAndPass.contains("checkBox") == true) {
            checkBox.setChecked(true)
            mail.setText(preffEmailAndPass.getString("mail", ""))
            pass.setText(preffEmailAndPass.getString("pass", ""))
        }
    }
}
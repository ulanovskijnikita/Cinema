package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class MainReg : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var family:EditText
    lateinit var mail:EditText
    lateinit var pass:EditText
    lateinit var passDouble:EditText

    val patternNameAndFamily = ("[a-zA-Zа-яА-я0-9]{1,15}")
    val patternMail = ("[a-zA-Z0-9]{1,100}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val patternPass = ("[a-zA-Z0-9!@#$%&()-+]{8,100}")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        name=findViewById(R.id.editTextTextPersonName)
        family=findViewById(R.id.editTextTextPersonFamily)
        mail=findViewById(R.id.editTextTextEmailAddress)
        pass=findViewById(R.id.editTextNumberPassword)
        passDouble=findViewById(R.id.editTextNumberPasswordDouble)
    }

    fun validNameAndFamily(text: String):Boolean {
        return Pattern.compile(patternNameAndFamily).matcher(text).matches()
    }

    fun validMail(text: String):Boolean {
        return Pattern.compile(patternMail).matcher(text).matches()
    }

    fun validPass(text: String):Boolean {
        return Pattern.compile(patternPass).matcher(text).matches()
    }

    fun nextToEnter(view: View) {
        val intent= Intent(this@MainReg, MainEnter::class.java)
        startActivity(intent)
        finish()
    }

    fun nextToToolbar(view: View) {
        if (name.text.toString().isNotEmpty() && family.text.toString().isNotEmpty() && mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty() && passDouble.text.toString().isNotEmpty()) {
            when (false) {
                validNameAndFamily(name.text.toString()) -> Toast.makeText(
                    this,
                    "Имя заполненна некорректно",
                    Toast.LENGTH_SHORT
                ).show()

                validNameAndFamily(family.text.toString()) -> Toast.makeText(
                    this,
                    "Фамилия заполненна некорректно",
                    Toast.LENGTH_SHORT
                ).show()

                validMail(mail.text.toString()) -> Toast.makeText(
                    this,
                    "Почта заполненна некорректно",
                    Toast.LENGTH_SHORT
                ).show()

                validPass(pass.text.toString()) -> Toast.makeText(
                    this,
                    "Пароль должен состоять из 8 и более символов",
                    Toast.LENGTH_SHORT
                ).show()

                (pass.text.toString() == passDouble.text.toString()) -> Toast.makeText(
                    this,
                    "Пароли не совпадают",
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    val intent = Intent(this@MainReg, ToolbarActivity::class.java)
                    val window=Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()
                    startActivity(intent)
                    finish()
                }
            }
        }
        else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Заполните текстовые поля")
                .setPositiveButton("ОК", null)
                .create()
                .show()
        }
    }
}
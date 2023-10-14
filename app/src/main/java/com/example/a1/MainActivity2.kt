package com.example.a1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class MainActivity2 : AppCompatActivity() {
    lateinit var mail: EditText
    lateinit var pass: EditText
    val patternMail = ("[a-zA-Z0-9]{1,100}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val patternPass = ("[a-zA-Z0-9!@#$%&()-+]{8,100}")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mail = findViewById(R.id.editTextTextEmailAddress)
        pass = findViewById(R.id.editTextTextPassword)
    }

    fun emailValid(text: String): Boolean {
        return Pattern.compile(patternMail).matcher(text).matches()
    }

    fun passValid(text: String): Boolean {
        return Pattern.compile(patternPass).matcher(text).matches()
    }

    fun nextToToolbar(view: View) {
        if (mail.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {
            when (false) {
                emailValid(mail.text.toString()) -> Toast.makeText(
                    this,
                    "Почта заполненна некорректно",
                    Toast.LENGTH_SHORT
                ).show()

                passValid(pass.text.toString()) -> Toast.makeText(
                    this,
                    "Пароль заполненн некорректно",
                    Toast.LENGTH_SHORT
                ).show()

                else -> {
                    val intent = Intent(this@MainActivity2, ToolbarActivity::class.java)
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

        fun nextToReg(view: View) {
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(intent)
            finish()
        }
}
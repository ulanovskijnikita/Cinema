package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cinema.db.RegDbManager

class EnterActivity : AppCompatActivity() {

    private lateinit var buttonToToolbar: Button
    private lateinit var buttonToReg: Button

    private var prefEmailAndPass = PrefMailAndPass()
    private val regDbManager = RegDbManager(this)

    private fun existenceMail(): Boolean {
        val mailArray = regDbManager.readDbDataMail()
        return mailArray.contains(prefEmailAndPass.mail.text.toString())
    }

    private fun existenceMailAndPass(): Boolean {
        val pass = regDbManager.readDbDataPassOfMail(prefEmailAndPass.mail.text.toString())
        return pass.contains(prefEmailAndPass.pass.text.toString())
    }

    private fun greeting(): String {
        return regDbManager.readDbDataNameOfMail(prefEmailAndPass.mail.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        prefEmailAndPass.preffEmailAndPass = getSharedPreferences("prefEmailAndPass", MODE_PRIVATE)

        prefEmailAndPass.mail = findViewById(R.id.editTextTextEmailAddressEnter)
        prefEmailAndPass.pass = findViewById(R.id.editTextTextPasswordEnter)
        prefEmailAndPass.checkBox = findViewById(R.id.checkBoxEnter)
        prefEmailAndPass.preffEmailAndPassContains()

        buttonToToolbar = findViewById(R.id.buttonToToolbar)
        buttonToReg = findViewById(R.id.buttonToReg)

        buttonToToolbar.setOnClickListener {
            if (prefEmailAndPass.mail.text.toString().isNotEmpty() && prefEmailAndPass.pass.text.toString().isNotEmpty()) {
                when (false) {
                    existenceMail() -> {
                        Toast.makeText(
                            this,
                            "Почта не зарегистрирована",
                            Toast.LENGTH_SHORT
                        ).show()
                        regDbManager.closeDb()
                    }

                    existenceMailAndPass() -> {
                        Toast.makeText(
                            this,
                            "Неверный пароль",
                            Toast.LENGTH_SHORT
                        ).show()
                        regDbManager.closeDb()
                    }

                    else -> {
                        prefEmailAndPass.preffEmailAndPassInsert()

                        Toast.makeText(this, "Добро пожаловать, " + greeting(), Toast.LENGTH_SHORT).show()
                        regDbManager.closeDb()

                        val intent = Intent(this, ToolbarActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Заполните текстовые поля")
                    .setPositiveButton("ОК", null)
                    .create()
                    .show()
            }
        }

        buttonToReg.setOnClickListener {
            val intent = Intent(this@EnterActivity, RegActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
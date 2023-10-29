package com.example.cinema
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cinema.db.regDbManager

class enterActivity : AppCompatActivity() {

    lateinit var buttonToToolbar: Button
    lateinit var buttonToReg: Button

    var preffEmailAndPass = preffMailAndPass()
    val regDbManager = regDbManager(this)

    fun existenceMail(): Boolean {
        val mailArray = regDbManager.readDbDataMail()
        val existence = mailArray.contains(preffEmailAndPass.mail.text.toString())
        return existence
    }

    fun existenceMailAndPass(): Boolean {
        val pass = regDbManager.readDbDataPassOfMail(preffEmailAndPass.mail.text.toString())
        val existence = pass.contains(preffEmailAndPass.pass.text.toString())
        return existence
    }

    fun greeting(): String {
        val name = regDbManager.readDbDataNameOfMail(preffEmailAndPass.mail.text.toString())
        return name
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        preffEmailAndPass.preffEmailAndPass = getSharedPreferences("preffEmailAndPass", MODE_PRIVATE)

        preffEmailAndPass.mail = findViewById(R.id.editTextTextEmailAddressEnter)
        preffEmailAndPass.pass = findViewById(R.id.editTextTextPasswordEnter)
        preffEmailAndPass.checkBox = findViewById(R.id.checkBoxEnter)
        preffEmailAndPass.preffEmailAndPassContains()

        buttonToToolbar = findViewById(R.id.buttonToToolbar)
        buttonToReg = findViewById(R.id.buttonToReg)

        buttonToToolbar.setOnClickListener() {
            if (preffEmailAndPass.mail.text.toString().isNotEmpty() && preffEmailAndPass.pass.text.toString().isNotEmpty()) {
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
                        preffEmailAndPass.preffEmailAndPassInsert()

                        Toast.makeText(this, "Добро пожаловать, " + greeting(), Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, toolbarActivity::class.java)
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

        buttonToReg.setOnClickListener() {
            val intent = Intent(this@enterActivity, regActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
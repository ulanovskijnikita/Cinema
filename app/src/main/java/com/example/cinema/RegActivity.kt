package com.example.cinema
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.cinema.db.RegDbManager
import java.util.regex.Pattern

class RegActivity : AppCompatActivity() {
    var preffEmailAndPass = PrefMailAndPass()
    val regDbManager = RegDbManager(this)

    lateinit var name:EditText
    lateinit var family:EditText
    lateinit var passDouble:EditText

    lateinit var regButton:Button
    lateinit var backToEnterButton:Button

    val patternNameAndFamily = ("[a-zA-Zа-яА-я0-9]{1,15}")
    val patternMail = ("[a-zA-Z0-9]{1,100}" + "@" + "[a-z]{1,6}" + "\\." + "[a-z]{1,5}")
    val patternPass = ("[a-zA-Z0-9!@#$%&()-+]{8,100}")

    fun validPass(text: String):Boolean {
        return Pattern.compile(patternPass).matcher(text).matches()
    }

    fun validNameAndFamily(text: String):Boolean {
        return Pattern.compile(patternNameAndFamily).matcher(text).matches()
    }

    fun validMail(text: String):Boolean {
        return Pattern.compile(patternMail).matcher(text).matches()
    }

    fun existenceMail(): Boolean {
        val mailArray = regDbManager.readDbDataMail()
        val existence = mailArray.contains(preffEmailAndPass.mail.text.toString())
        return existence
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        preffEmailAndPass.preffEmailAndPass = getSharedPreferences("preffEmailAndPass", MODE_PRIVATE)

        preffEmailAndPass.mail=findViewById(R.id.editTextTextEmailAddressReg)
        preffEmailAndPass.checkBox = findViewById(R.id.checkBoxReg)
        preffEmailAndPass.pass=findViewById(R.id.editTextTextPasswordReg)

        name=findViewById(R.id.editTextTextPersonNameReg)
        family=findViewById(R.id.editTextTextPersonFamilyReg)
        passDouble=findViewById(R.id.editTextTextPasswordDoubleReg)

        regButton=findViewById(R.id.regButton)
        backToEnterButton=findViewById(R.id.backToEnterButton)

        regButton.setOnClickListener {
            if (name.text.toString().isNotEmpty() && family.text.toString().isNotEmpty() && preffEmailAndPass.mail.text.toString().isNotEmpty() && preffEmailAndPass.pass.text.toString().isNotEmpty() && passDouble.text.toString().isNotEmpty()) {
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

                    validMail(preffEmailAndPass.mail.text.toString()) -> Toast.makeText(
                        this,
                        "Почта заполненна некорректно",
                        Toast.LENGTH_SHORT
                    ).show()

                    !existenceMail() -> {
                        Toast.makeText(
                            this,
                            "Почта уже зарегестрирована",
                            Toast.LENGTH_SHORT
                        ).show()
                        regDbManager.closeDb()
                    }

                    validPass(preffEmailAndPass.pass.text.toString()) -> Toast.makeText(
                        this,
                        "Пароль должен состоять из 8 и более символов",
                        Toast.LENGTH_SHORT
                    ).show()

                    (preffEmailAndPass.pass.text.toString() == passDouble.text.toString()) -> Toast.makeText(
                        this,
                        "Пароли не совпадают",
                        Toast.LENGTH_SHORT
                    ).show()

                    else -> {
                        regDbManager.insertToDb(name.text.toString(), family.text.toString(), preffEmailAndPass.mail.text.toString(), preffEmailAndPass.pass.text.toString())
                        regDbManager.closeDb()
                        preffEmailAndPass.preffEmailAndPassInsert()

                        Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_LONG).show()

                        val intent = Intent(this@RegActivity, EnterActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
            else {
                AlertDialog.Builder(this)
                    .setTitle("Заполните текстовые поля")
                    .setPositiveButton("ОК", null)
                    .create()
                    .show()
            }
        }

        backToEnterButton.setOnClickListener {
            val intent= Intent(this@RegActivity, EnterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

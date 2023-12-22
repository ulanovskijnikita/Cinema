package com.example.cinema

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.cinema.databinding.ActivityTestBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestActivity : AppCompatActivity() {
    private var prefMailAndPass = PrefMailAndPass()

    fun backToFilms() {
        val intent= Intent(this, FilmsActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun backToToolbar() {
        val intent= Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
        finish()
    }
    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefMailAndPass.preffEmailAndPass = getSharedPreferences("prefNameAndFamily", MODE_PRIVATE)
        prefMailAndPass.preffNameAndFamily = getSharedPreferences("prefEmailAndPass", MODE_PRIVATE)
        binding.nameView.text = "Как дела, ${prefMailAndPass.preffEmailAndPass.getString("name and family", "")}?"

        R.layout.activity_test
        val bn:BottomNavigationView=findViewById(R.id.bottom)
        bn.selectedItemId=R.id.gear
        bn.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home->{
                    backToToolbar()
                }
                R.id.heart->{backToFilms()}
                R.id.gear->{Toast.makeText(this, "Вы уже здесь", Toast.LENGTH_SHORT).show()}
            }
            true
        }
    }

    fun reset(view: View) {
        prefMailAndPass.preffEmailAndPassDeleteAll(prefMailAndPass.preffEmailAndPass)
        prefMailAndPass.preffEmailAndPassDeleteAll(prefMailAndPass.preffNameAndFamily)

        val intent= Intent(this@TestActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
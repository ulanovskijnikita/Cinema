package com.example.a1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity4 : AppCompatActivity() {
    fun backToFilms() {
        val intent= Intent(this, filmsActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun backToToolbar() {
        val intent= Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

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
        val intent= Intent(this@MainActivity4, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
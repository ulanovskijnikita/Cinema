package com.example.cinema

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class filmsActivity : AppCompatActivity() {
    lateinit var tl:TabLayout
    lateinit var vp:ViewPager2
    private val fragList=listOf(filmsFragment(), filmsFragment2(), filmsFragment3())
    private val tabList=listOf("В тренде", "Новинки", "Для Вас")


    fun backToMainActivity4() {
        val intent= Intent(this, ActivityTest::class.java)
        startActivity(intent)
        finish()
    }

    fun backToToolbar() {
        val intent= Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
        finish()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.opacity)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)
        tl=findViewById(R.id.tabLayout1)
        vp=findViewById(R.id.framentHolder)
        val adapter=filmsFragments(this, fragList)
        vp.adapter=adapter
        TabLayoutMediator(tl, vp) {
            tab, pos ->tab.text=tabList[pos]
        }.attach()

        val bn: BottomNavigationView =findViewById(R.id.bottom)
        bn.selectedItemId=R.id.heart
        bn.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home->{backToToolbar()}
                R.id.heart->{Toast.makeText(this, "Вы уже здесь", Toast.LENGTH_SHORT).show()}
                R.id.gear->{backToMainActivity4()}
            }
            true
        }
    }
}
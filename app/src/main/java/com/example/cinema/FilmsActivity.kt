package com.example.cinema

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

class FilmsActivity : AppCompatActivity() {
    private lateinit var TL:TabLayout
    private lateinit var VP2:ViewPager2
    private val fragList=listOf(FilmsFragment(), FilmsFragment2(), FilmsFragment3())
    private val tabList=listOf("В тренде", "Новинки", "Для Вас")


    private fun backToMainActivity4() {
        val intent= Intent(this, TestActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun backToToolbar() {
        val intent= Intent(this, ToolbarActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.opacity)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        TL=findViewById(R.id.tabLayout1)
        VP2=findViewById(R.id.fragmentHolder)
        val adapter=FilmsFragments(this, fragList)
        VP2.adapter = adapter
        TabLayoutMediator(TL, VP2) {
            tab, pos ->tab.text = tabList[pos]
        }.attach()

        val bn: BottomNavigationView =findViewById(R.id.bottom)
        bn.selectedItemId = R.id.heart
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
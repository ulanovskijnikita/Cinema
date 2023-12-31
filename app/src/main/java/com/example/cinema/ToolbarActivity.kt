package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.retrofit.`interface`.RetrofitServieces
import com.example.cinema.retrofit.model.Data
import com.example.cinema.retrofit.MyRetrofit
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Response

class ToolbarActivity : AppCompatActivity() {
    lateinit var tb:Toolbar
    fun backToMainActivity4() {
        val intent= Intent(this, TestActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun backToFilms() {
        val intent= Intent(this, FilmsActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        val bn: BottomNavigationView =findViewById(R.id.bottom)
        bn.selectedItemId=R.id.home
        bn.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home->Toast.makeText(this, "Вы уже здесь", Toast.LENGTH_SHORT).show()
                R.id.heart->backToFilms()
                R.id.gear->backToMainActivity4()
            }
            true
        }

////        Видео с ссылки
//        val video:VideoView=findViewById(R.id.videoView)
//        val mediaCompiler=MediaController(this)
//        mediaCompiler.setAnchorView(video)
//        val onLineurl= Uri.parse("https://rr3---sn-25ge7nzd.googlevideo.com/videoplayback?e xpire=1671038319&ei=D7GZY42gGo6L6dsP_7GxuAk&ip=185.147.21 2.18&id=o-ALB2_2a8QS1d8guABM4x1RCFL78MzCMu-BPyym2nZFmM&it ag=18&source=youtube&requiressl=yes&mh=pm&mm=31%2C26&mn=s n-25ge7nzd%2Csn-h5qzened&ms=au%2Conr&mv=m&mvi=3&pl=24&ini tcwndbps=702500&spc=zIddbCVt1AqOUpQt9mWJGT01jjnMcws&vprv= 1&mime=video%2Fmp4&ns=H7pnqCuW5loMz_b62l6hRTwK&cnr=14&rat ebypass=yes&dur=165.720&lmt=1664315358357458&mt=167101592 2&fvip=1&fexp=24001373%2C24007246&c=WEB&txp=5538434&n=Uwr f6OHMHatKEQ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource %2Crequiressl%2Cspc%2Cvprv%2Cmime%2Cns%2Ccnr%2Cratebypass %2Cdur%2Clmt&sig=AOq0QJ8wRAIgXryJbfZstp62DU1bSqDeOvqjy7eM LxfzjxcFF_xb1tYCIAD7M7OucMuCqmBG7fvCsgkRcST46b1UaTia8SaUj Ous&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwnd 23bps&lsig=AG3C_xAwRAIgGD7WKFXwscjZbqKPXvkal3NE-lvzPplJGZfS h_JUqbACIDH5N2KxxcpQ99q2S-fUP78mVR1Q7uZ9kyIjbyj8RsTu")
//        video.setMediaController(mediaCompiler)
//        video.setVideoURI(onLineurl)
//        video.requestFocus()
//        video.start()

//        Скаченное видео
        val video:VideoView = findViewById(R.id.videoView2)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        val onLineUrl= Uri.parse("android.resource://$packageName/${R.raw.treiler}")
        video.setMediaController(mediaController)
        video.setVideoURI(onLineUrl)

//        Recycler с кадрами
        val cardRes:RecyclerView = findViewById(R.id.card)
        cardRes.adapter = CardAdapter(this, CardList().cList)

//        Recycler с актёрами
        val person_res:RecyclerView = findViewById(R.id.person)
        person_res.adapter = PersonAdapter(this, person_list().p_list)

////        Recycler с Retrofit'а
//        val personRes:RecyclerView = findViewById(R.id.person)
//        val retrofit = MyRetrofit().getRetrofit()
//        val apiRet = retrofit.create(RetrofitServieces::class.java)
//        val retCall:Call<Data> = apiRet.getImage()
//        retCall.enqueue(object:retrofit2.Callback<Data> {
//            override fun onResponse(call: Call<Data>, response: Response<Data>) {
//                if (response.isSuccessful) {
//                    personRes.adapter = response.body()?.let { PersonAdapter(applicationContext, it.data) }
//                }
//            }
//            override fun onFailure(call: Call<Data>, t: Throwable) {
//                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//        })

        tb=findViewById(R.id.toolbar)
        setSupportActionBar(this.tb)
        supportActionBar?.title="Хищные птицы"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean {
        menuInflater.inflate(R.menu.menu_of_five_activity, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val inte = Intent(this, EnterActivity::class.java)
                startActivity(inte)
                finish()
            }
            R.id.icon_check -> {
                Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }
}
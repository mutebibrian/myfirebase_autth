package com.kotlinseries.mysplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    //declare variblae valled analytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        analytics = Firebase.analytics
        val logo:ImageView = findViewById(R.id.IVimage)
        val title:TextView = findViewById(R.id.tvtitle)
        val progressBar:ProgressBar = findViewById(R.id.splashprogress)
        val version:TextView = findViewById(R.id.tvversion)
        val top_anim : Animation = AnimationUtils.loadAnimation(this,R.anim.top)
        val bottom_anim : Animation = AnimationUtils.loadAnimation(this,R.anim.bottom)
        logo.startAnimation(top_anim)
        title.startAnimation(bottom_anim)
        progressBar.startAnimation(bottom_anim)
        version.startAnimation(bottom_anim)

        Handler().postDelayed({
         startActivity(Intent(this,MainActivity::class.java))
         finish()



        }
        ,3000)




    }
}
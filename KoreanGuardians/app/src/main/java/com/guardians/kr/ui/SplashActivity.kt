package com.guardians.kr.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.guardians.kr.R
import com.guardians.kr.ui.login.LoginActivity
import com.guardians.kr.ui.main.MainActivity
import com.guardians.kr.util.SharedPreferenceController

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setSplashGif()
    }

    private fun setSplashGif() {
        val viewImage = findViewById<View>(R.id.iv_splash_splash) as ImageView
        val gifImage = GlideDrawableImageViewTarget(viewImage)
        Glide.with(this).load(R.drawable.splash).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(gifImage)

        val handler = Handler()
        handler.postDelayed({
            if(SharedPreferenceController.instance.getToken(this)!=""){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 3200)
    }
}

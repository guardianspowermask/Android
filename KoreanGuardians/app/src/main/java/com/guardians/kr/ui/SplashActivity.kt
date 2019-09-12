package com.guardians.kr.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget
import com.guardians.kr.R
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.network.get.GetItemResponse
import com.guardians.kr.ui.login.LoginActivity
import com.guardians.kr.ui.main.MainActivity
import com.guardians.kr.util.SharedPreferenceController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
    private var networkService : NetworkService = ApplicationController.instance.networkService

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
                val getItem = networkService.getItem(SharedPreferenceController.instance.getToken(this), 1, 0)
                getItem.enqueue(object : Callback<GetItemResponse> {
                    override fun onFailure(call: Call<GetItemResponse>?, t: Throwable?) {
                        Log.d("Error::Splash", "$t")
                    }

                    override fun onResponse(call: Call<GetItemResponse>?, response: Response<GetItemResponse>?) {
                        if (response!!.message().length >= 8) {
                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                            finish()
                        }else{
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                            finish()
                        }
                    }
                })
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }, 3200)
    }
}

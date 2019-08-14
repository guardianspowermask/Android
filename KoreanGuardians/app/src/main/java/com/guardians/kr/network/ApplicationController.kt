package com.guardians.kr.network

import android.app.Application
import com.guardians.kr.kakao.GlobalApplication
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : GlobalApplication() {
    lateinit var networkService: NetworkService
    private val baseUrl = "http://13.125.105.66:3000/"

    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork() {
        val builder = Retrofit.Builder()
        val retrofit = builder
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkService = retrofit.create(NetworkService::class.java)
    }
}
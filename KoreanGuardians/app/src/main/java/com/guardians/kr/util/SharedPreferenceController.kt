package com.guardians.kr.util

import android.app.Activity
import android.content.Context

class SharedPreferenceController private constructor() {
    // login token
    fun setToken(context: Context, token: String) {
        val pref = context.getSharedPreferences("TOKEN", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("TOKEN", token)
        editor.apply()
    }
    fun getToken(context: Context): String {
        val pref = context.getSharedPreferences("TOKEN", Activity.MODE_PRIVATE)
        return pref.getString("TOKEN", "")?:""
    }

    companion object {
        private var SINGLETON_INSTANCE: SharedPreferenceController? = null

        val instance: SharedPreferenceController
            get() {
                if (SINGLETON_INSTANCE == null) {
                    SINGLETON_INSTANCE = SharedPreferenceController()
                }
                return SINGLETON_INSTANCE!!
            }
    }
}

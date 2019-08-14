package com.guardians.kr.kakao

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.post.PostLoginRequestDTO
import com.guardians.kr.post.PostStringResponseData
import com.guardians.kr.ui.login.LoginActivity
import com.guardians.kr.ui.main.MainActivity
import com.guardians.kr.util.SharedPreferenceController
import com.kakao.util.exception.KakaoException
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.UserManagement
import com.kakao.auth.ISessionCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SessionCallback(val ctx: Context) : ISessionCallback {
    private var networkService : NetworkService = ApplicationController.instance.networkService

    override fun onSessionOpened() {

        UserManagement.requestMe(object : MeResponseCallback() {
            override fun onFailure(errorResult: ErrorResult?) {
                ctx.startActivity(Intent(ctx, LoginActivity::class.java))
            }

            override fun onSessionClosed(errorResult: ErrorResult) {}

            override fun onNotSignedUp() {

            }

            override fun onSuccess(userProfile: UserProfile) {
                val postLogin = networkService.postLogin(PostLoginRequestDTO(userProfile.id.toString(), userProfile.nickname))
                postLogin.enqueue(object : Callback<PostStringResponseData>{
                    override fun onFailure(call: Call<PostStringResponseData>?, t: Throwable?) {
                        Log.d("Error::Login", "$t")
                    }

                    override fun onResponse(call: Call<PostStringResponseData>?,response: Response<PostStringResponseData>?) {
                        if (response!!.isSuccessful) {
                            SharedPreferenceController.instance.setToken(ctx, response.body().data)
                            ctx.startActivity(Intent(ctx, MainActivity::class.java))
                            (ctx as Activity).finish()
                        }
                    }
                })
            }
        })
    }

    // 세션 실패시
    override fun onSessionOpenFailed(exception: KakaoException) {


    }
}

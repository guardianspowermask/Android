package com.guardians.kr.kakao

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.network.post.PostLoginRequestDTO
import com.guardians.kr.network.post.PostStringResponseData
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



class SessionCallback(val ctx : Context) : ISessionCallback{
    val networkService = ApplicationController.instance.networkService
    // 로그인에 실패
    override fun onSessionOpenFailed(exception: KakaoException?) {
    }

    // 로그인에 성공
    override fun onSessionOpened() {

        UserManagement.requestMe(object : MeResponseCallback() {
            override fun onFailure(errorResult: ErrorResult?) {
                ctx.startActivity(Intent(ctx, LoginActivity::class.java))
            }

            override fun onSessionClosed(errorResult: ErrorResult) {
                Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult!!.errorMessage)
            }

            override fun onNotSignedUp() {
                Log.e("SessionCallback :: ", "onNotSignedUp")
            }

            override fun onSuccess(userProfile: UserProfile) {
                Log.d("asd", "${userProfile.profileImagePath} - ${userProfile.uuid}")
                val postLogin = networkService.postLogin(
                    PostLoginRequestDTO(
                        userProfile.id.toString(),
                        userProfile.nickname
                    )
                )
                postLogin.enqueue(object : Callback<PostStringResponseData>{
                    override fun onFailure(call: Call<PostStringResponseData>?, t: Throwable?) {
                        Log.d("Error::Login", "$t")
                    }

                    override fun onResponse(call: Call<PostStringResponseData>?, response: Response<PostStringResponseData>?) {
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
}
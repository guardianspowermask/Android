package com.guardians.kr.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guardians.kr.R
import com.guardians.kr.kakao.SessionCallback
import com.guardians.kr.ui.main.MainActivity
import com.kakao.auth.AuthType
import com.kakao.auth.Session
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        iv_kakao_login.setOnClickListener {
            val session = Session.getCurrentSession()
            session.addCallback(SessionCallback(this))
            session.open(AuthType.KAKAO_ACCOUNT, this)

        }

        tv_guest_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

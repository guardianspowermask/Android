package com.guardians.kr.ui.detail

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.guardians.kr.R
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.network.get.GetCommentResponse
import com.guardians.kr.network.get.GetCommentResponseData
import com.guardians.kr.network.post.PostBlankResponse
import com.guardians.kr.network.post.PostCommentRequestDTO
import com.guardians.kr.ui.login.LoginActivity
import com.guardians.kr.ui.main.CommentAdapter
import com.guardians.kr.util.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity() {
    private var networkService : NetworkService = ApplicationController.instance.networkService

    private var commentItems: ArrayList<GetCommentResponseData> = ArrayList()
    private lateinit var commentAdapter: CommentAdapter

    private var firstTouch = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO 키보드 처리

        // set Status bar Transparent
        // editText hide
//        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        // Full Screen
        // editText doesn't hide
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)


        setContentView(R.layout.activity_detail)

        setItemInfo()
        communicate()
        setClickListener()
    }

    private fun setItemInfo() {
        tv_name_detail.text = intent.getStringExtra("NAME")
        tv_store_detail.text = "제조사 / ${intent.getStringExtra("STORE")}"
        Glide.with(this).load(intent.getStringExtra("IMG")).into(iv_img_detail)
        if (intent.getIntExtra("FEEDBACK_FLAG", 0) == 0){
            btn_feedback_detail.background = ContextCompat.getDrawable(this, R.drawable.custom_btn_gray)
        }
    }

    private fun communicate() {
        val getComment = networkService.getComment(intent.getIntExtra("ITEM_IDX", 0))
        getComment.enqueue(object : Callback<GetCommentResponse>{
            override fun onFailure(call: Call<GetCommentResponse>?, t: Throwable?) {
                Log.d("Error::Comment", "$t")
            }

            override fun onResponse(call: Call<GetCommentResponse>?, response: Response<GetCommentResponse>?) {
                if (response!!.isSuccessful) {
                    tv_cnt_detail.text = response.body().data.size.toString()
                    commentItems = response.body().data
                    if (commentItems.size != 0) {
                        const_bubble_detail.visibility = View.INVISIBLE
                        setRecyclerView()
                    }
                }
            }

        })
    }

    private fun setRecyclerView() {
        commentAdapter = CommentAdapter(this, commentItems)
        LinearLayoutManager(this).let{
            it.reverseLayout = true
            it.stackFromEnd = true
            rv_comment_detail.layoutManager = it
        }
        rv_comment_detail.adapter = commentAdapter

    }

    private fun setClickListener() {
        if(intent.getIntExtra("FEEDBACK_FLAG", 0)!=0) {
            btn_feedback_detail.setOnClickListener {
                FeedbackDialog(this, intent.getStringExtra("STORE"), intent.getIntExtra("ITEM_IDX", 0)).show()
            }
        }

        tv_btn_detail.setOnClickListener {
            if (SharedPreferenceController.instance.getToken(this)==""){
                Toast.makeText(this, "로그인 후 이용해주세요.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                val postComment = networkService.postComment(SharedPreferenceController.instance.getToken(this), PostCommentRequestDTO(intent.getIntExtra("ITEM_IDX", 0), et_comment_detail.text.toString()))
                postComment.enqueue(object : Callback<PostBlankResponse>{
                    override fun onFailure(call: Call<PostBlankResponse>?, t: Throwable?) {
                        Log.d("Error::PostComment", "$t")
                    }

                    override fun onResponse(call: Call<PostBlankResponse>?, response: Response<PostBlankResponse>?) {
                        if (response!!.isSuccessful) {
                            communicate()
                            et_comment_detail.setText("")
                            firstTouch = false
                        }
                    }
                })
            }
        }

        et_comment_detail.setOnTouchListener { v, event ->
            if(!firstTouch)
                et_comment_detail.setText("항의합니다.")
            firstTouch = true
            false
        }
    }
}

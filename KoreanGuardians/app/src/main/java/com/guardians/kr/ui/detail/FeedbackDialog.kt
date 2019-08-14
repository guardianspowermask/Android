package com.guardians.kr.ui.detail

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import com.bumptech.glide.Glide
import com.guardians.kr.R
import com.guardians.kr.get.GetFeedbackResponse
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import kotlinx.android.synthetic.main.dialog_feedback.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedbackDialog : Dialog {
    private var networkService : NetworkService = ApplicationController.instance.networkService

    constructor(context: Context, store: String, item_idx: Int) : super(context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_feedback)
        tv_store_dialog_feedback.text = "$store 피드백"

        val getFeedback = networkService.getItemFeedback(item_idx)
        getFeedback.enqueue(object : Callback<GetFeedbackResponse>{
            override fun onFailure(call: Call<GetFeedbackResponse>?, t: Throwable?) {
                Log.d("Error::Dialog", "$t")
            }

            override fun onResponse(call: Call<GetFeedbackResponse>?, response: Response<GetFeedbackResponse>?) {
                if (response!!.isSuccessful) {
                    tv_date_dialog_feedback.text = response.body().data.date
                    Glide.with(context).load(response.body().data.img).into(iv_img_dialog_feedback)
                }
            }

        })
    }
}
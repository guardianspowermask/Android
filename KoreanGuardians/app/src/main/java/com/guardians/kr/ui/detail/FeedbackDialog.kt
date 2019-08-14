package com.guardians.kr.ui.detail

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.guardians.kr.R
import kotlinx.android.synthetic.main.dialog_feedback.*

class FeedbackDialog : Dialog {
    constructor(context: Context, store: String) : super(context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_feedback)
        tv_store_dialog_feedback.text = "$store 피드백"
        // TODO 통신, 뷰 설정
    }
}
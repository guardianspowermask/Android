package com.guardians.kr.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.guardians.kr.R
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.guardians.kr.ui.main.CommentAdapter
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private var commentItems: ArrayList<CommentData> = ArrayList()
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // TODO 키보드 처리

        // set Status bar Transparent
        // editText hide
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        // Full Screen
        // editText doesn't hide
//        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
//        window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)


        setContentView(R.layout.activity_detail)

        setItemInfo()
        communicate()
        setRecyclerView()
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
        // TODO 피드백 여부, 항의 개수, 댓글 가져오기
    }

    private fun setRecyclerView() {
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentItems.add(CommentData("송**", "2019 09/03", "항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. 항의합니다. "))
        commentAdapter = CommentAdapter(this, commentItems)
        rv_comment_detail.layoutManager = LinearLayoutManager(this)
        rv_comment_detail.adapter = commentAdapter

    }

    private fun setClickListener() {
        if(intent.getIntExtra("FEEDBACK_FLAG", 0)!=0) {
            btn_feedback_detail.setOnClickListener {
                FeedbackDialog(this, intent.getStringExtra("STORE"), intent.getIntExtra("ITEM_IDX", 0)).show()
            }
        }

        tv_btn_detail.setOnClickListener {
            // TODO 항의하기 통신
            // TODO RecyclerView 에 댓글 추가, 항의 count up, EditText Clear
        }
    }
}

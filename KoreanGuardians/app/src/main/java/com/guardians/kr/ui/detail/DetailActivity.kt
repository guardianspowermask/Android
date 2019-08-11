package com.guardians.kr.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guardians.kr.R
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import com.guardians.kr.ui.main.CommentAdapter
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private var commentItems: ArrayList<CommentData> = ArrayList()
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // set Status bar Transparent
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        setRecyclerView()
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
}

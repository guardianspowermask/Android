package com.guardians.kr.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guardians.kr.R
import android.view.WindowManager
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.guardians.kr.ui.main.CommentAdapter
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {
    private var commentItems: ArrayList<CommentData> = ArrayList()
    private lateinit var commentAdapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val w = window
//        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)

//        setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
//        window.statusBarColor = Color.TRANSPARENT;

//        StatusBarUtil.setTransparent(this)
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val decor = window.decorView
//            decor.systemUiVisibility = 0
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0x00000000  // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            window.addFlags(flags)
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        setRecyclerview()
    }

    private fun setRecyclerview() {
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

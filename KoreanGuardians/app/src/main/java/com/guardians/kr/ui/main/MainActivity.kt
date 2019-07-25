package com.guardians.kr.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.guardians.kr.R


class MainActivity : AppCompatActivity() {
    private var categoryItems: ArrayList<CategoryItem> = ArrayList()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
        setClickListener()
    }

    private fun setRecyclerView() {
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))
        categoryItems.add(CategoryItem("모찌", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 125, arrayListOf("찹쌀떡", "찰떡")))

        categoryAdapter = CategoryAdapter(this, categoryItems)
        rv_category_main.layoutManager = GridLayoutManager(this, 2)
        rv_category_main.adapter = categoryAdapter
    }

    private fun setClickListener() {
        btn_inform_main.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("gaksital.official@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "[제보] 일본어 사용 제품 제보합니다!")
            intent.putExtra(Intent.EXTRA_TEXT, "제품명: \nex) CU 리얼초코모찌롤\n\n제조사: \nex) CJ 푸드빌\n\n한 마디: \n\n위 제품을 제보합니다. \n각시탈 파이팅 :)")

            startActivity(Intent.createChooser(intent, "항의 메일 보내기"))
        }
    }
}

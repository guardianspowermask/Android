package com.guardians.kr.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.guardians.kr.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var categoryItems: ArrayList<CategoryItem>
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
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
}

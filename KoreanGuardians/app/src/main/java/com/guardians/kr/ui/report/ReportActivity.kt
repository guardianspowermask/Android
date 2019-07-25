package com.guardians.kr.ui.report

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.guardians.kr.R
import com.guardians.kr.get.GetCategoryResponseData
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.ui.main.CategoryReportAdapter
import com.guardians.kr.ui.main.ItemAdapter
import kotlinx.android.synthetic.main.activity_report.*

class ReportActivity : AppCompatActivity() {
    var networkService : NetworkService = ApplicationController.instance.networkService

    private var categoryItems: ArrayList<CategoryReportItem> = ArrayList()
    private lateinit var categoryAdapter: CategoryReportAdapter
    private var itemItems: ArrayList<ItemItem> = ArrayList()
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        setRecyclerCategory()
        setCommunication()
        setRecyclerItem()
        tv_cnt_report.text = "${514}건"
    }

    private fun setRecyclerCategory() {
        val intentItems = intent.getParcelableArrayListExtra<GetCategoryResponseData>("CATEGORY")
        val selectedIdx = intent.getIntExtra("IDX", -1)

        for (i in 0 until intentItems.size)
            categoryItems.add(CategoryReportItem(selectedIdx == intentItems[i].category_idx, intentItems[i].category_idx, intentItems[i].name))

        categoryAdapter = CategoryReportAdapter(this, categoryItems)
        rv_category_report.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_category_report.adapter = categoryAdapter
    }

    private fun setCommunication() {

    }

    private fun setRecyclerItem() {
        itemItems.add(ItemItem("모찌롤", "CU", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 141, "danfwjdnw@na.kr", "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 141, null, "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "https://avatars1.githubusercontent.com/u/18085486?s=460&v=4", 141, null, "dqwdwsdcwd23"))

        itemAdapter = ItemAdapter(this, itemItems)
        rv_item_report.layoutManager = LinearLayoutManager(this)
        rv_item_report.adapter = itemAdapter
    }

}

package com.guardians.kr.ui.report

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.guardians.kr.R
import com.guardians.kr.ui.main.CategoryReportAdapter
import com.guardians.kr.ui.main.ItemAdapter
import kotlinx.android.synthetic.main.activity_report.*

class ReportActivity : AppCompatActivity() {
    private var categoryItems: ArrayList<CategoryReportItem> = ArrayList()
    private lateinit var categoryAdapter: CategoryReportAdapter
    private var itemItems: ArrayList<ItemItem> = ArrayList()
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        setRecyclerCategory()
        setRecyclerItem()
        tv_cnt_report.text = "${514}건"
    }

    private fun setRecyclerCategory() {
        categoryItems.add(CategoryReportItem(true, "전체"))
        categoryItems.add(CategoryReportItem(false, "모찌"))
        categoryItems.add(CategoryReportItem(false, "카라이"))
        categoryItems.add(CategoryReportItem(false, "산도"))
        categoryItems.add(CategoryReportItem(false, "타마고"))
        categoryItems.add(CategoryReportItem(false, "모찌"))
        categoryItems.add(CategoryReportItem(false, "카라이"))
        categoryItems.add(CategoryReportItem(false, "산도"))
        categoryItems.add(CategoryReportItem(false, "타마고"))

        categoryAdapter = CategoryReportAdapter(this, categoryItems)
        rv_category_report.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_category_report.adapter = categoryAdapter
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

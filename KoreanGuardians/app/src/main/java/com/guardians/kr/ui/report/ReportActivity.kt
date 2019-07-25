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
        rv_category_report.layoutManager = LinearLayoutManager(this)
        rv_category_report.adapter = categoryAdapter
    }

    private fun setRecyclerItem() {
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, null, "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, null, "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, "danfwjdnw@na.kr", null))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, null, "dqwdwsdcwd23"))
        itemItems.add(ItemItem("모찌롤", "CU", "http://pds21.egloos.com/pds/201903/26/18/d0050518_5c98f84abf43c.jpg", 141, null, "dqwdwsdcwd23"))

        itemAdapter = ItemAdapter(this, itemItems)
        rv_item_report.layoutManager = LinearLayoutManager(this)
        rv_item_report.adapter = itemAdapter
    }

}

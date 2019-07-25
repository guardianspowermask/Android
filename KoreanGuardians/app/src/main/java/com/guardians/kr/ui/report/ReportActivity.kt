package com.guardians.kr.ui.report

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.guardians.kr.R
import com.guardians.kr.get.GetCategoryResponse
import com.guardians.kr.get.GetCategoryResponseData
import com.guardians.kr.get.GetItemResponse
import com.guardians.kr.get.GetItemResponseDataItem
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.ui.main.CategoryReportAdapter
import com.guardians.kr.ui.main.ItemAdapter
import kotlinx.android.synthetic.main.activity_report.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportActivity : AppCompatActivity() {
    var networkService : NetworkService = ApplicationController.instance.networkService

    private var categoryItems: ArrayList<CategoryReportItem> = ArrayList()
    private lateinit var categoryAdapter: CategoryReportAdapter
    private var itemItems: ArrayList<GetItemResponseDataItem> = ArrayList()
    private lateinit var itemAdapter: ItemAdapter

    var selectedIdx : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        setRecyclerCategory()
        setCommunication(selectedIdx, 0)
        setRecyclerItem()
    }

    private fun setRecyclerCategory() {
        val intentItems = intent.getParcelableArrayListExtra<GetCategoryResponseData>("CATEGORY")
        selectedIdx = intent.getIntExtra("IDX", -1)

        for (i in 0 until intentItems.size)
            categoryItems.add(CategoryReportItem(selectedIdx == intentItems[i].category_idx, intentItems[i].category_idx, intentItems[i].name))

        categoryAdapter = CategoryReportAdapter(this, categoryItems)
        rv_category_report.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_category_report.adapter = categoryAdapter
    }

    private fun setCommunication(idx: Int, order: Int) {
        val getItem = networkService.getItem(idx, order)
        getItem.enqueue(object : Callback<GetItemResponse> {
            override fun onFailure(call: Call<GetItemResponse>?, t: Throwable?) {
                Log.d("Error::Main", "$t")
            }

            override fun onResponse(call: Call<GetItemResponse>?, response: Response<GetItemResponse>?) {
                if (response!!.isSuccessful) {
                    tv_cnt_report.text = "${response.body().data.total_cnt}건"
                    itemItems = response.body().data.items
                    setRecyclerItem()
                }
            }
        })
    }

    private fun setRecyclerItem() {
        itemAdapter = ItemAdapter(this, itemItems)
        rv_item_report.layoutManager = LinearLayoutManager(this)
        rv_item_report.adapter = itemAdapter
    }

}

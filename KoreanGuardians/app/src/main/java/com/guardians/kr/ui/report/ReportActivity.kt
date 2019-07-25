package com.guardians.kr.ui.report

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
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

class ReportActivity : AppCompatActivity(), View.OnClickListener {
    private var networkService : NetworkService = ApplicationController.instance.networkService

    private var categoryItems: ArrayList<CategoryReportItem> = ArrayList()
    private lateinit var categoryAdapter: CategoryReportAdapter
    private var itemItems: ArrayList<GetItemResponseDataItem> = ArrayList()
    private lateinit var itemAdapter: ItemAdapter

    private var selectedIdx : Int = -1
    private var selectedOrder : Int = 0

    override fun onClick(v: View?) {
        val idx : Int = rv_category_report.getChildAdapterPosition(v!!)

        // change btn color
        for (i in 0 until categoryItems.size)
            categoryItems[i].flag = false

        v.background = ContextCompat.getDrawable(this, R.drawable.custom_btn_on)
        categoryItems[idx].flag = true

        selectedIdx = categoryItems[idx].category_idx

        setCommunication(selectedIdx, selectedOrder)

        categoryAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        setRecyclerCategory()
        setRecyclerItem()
        setCommunication(selectedIdx, selectedOrder)
    }

    private fun setRecyclerCategory() {
        val intentItems = intent.getParcelableArrayListExtra<GetCategoryResponseData>("CATEGORY")
        selectedIdx = intent.getIntExtra("IDX", -1)

        var idx = 0
        for (i in 0 until intentItems.size) {
            if (selectedIdx == intentItems[i].category_idx) {
                idx = i
                categoryItems.add(CategoryReportItem(true, intentItems[i].category_idx, intentItems[i].name))
            } else {
                categoryItems.add(CategoryReportItem(false, intentItems[i].category_idx, intentItems[i].name))
            }
        }

        categoryAdapter = CategoryReportAdapter(this, categoryItems)
        categoryAdapter.setOnItemClickListener(this)
        rv_category_report.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_category_report.adapter = categoryAdapter
        rv_category_report.scrollToPosition(idx)
    }

    private fun setCommunication(idx: Int, order: Int) {
        val getItem = networkService.getItem(idx, order)
        getItem.enqueue(object : Callback<GetItemResponse> {
            override fun onFailure(call: Call<GetItemResponse>?, t: Throwable?) {
                Log.d("Error::Report", "$t")
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

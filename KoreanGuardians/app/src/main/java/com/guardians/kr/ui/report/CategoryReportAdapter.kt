package com.guardians.kr.ui.main

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guardians.kr.R
import com.guardians.kr.ui.report.CategoryReportItem

class CategoryReportAdapter(var ctx: Context, var categoryItems: ArrayList<CategoryReportItem>) : RecyclerView.Adapter<CategoryReportViewHolder>() {
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){ //3. 외부에서 넘어온 클릭리스너 설정
        onItemClick = l
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryReportViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category_report, parent, false)
        mainView.setOnClickListener(onItemClick)
        return CategoryReportViewHolder(mainView)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: CategoryReportViewHolder, position: Int) {
        holder.name_tv.text = categoryItems[position].name

        // set default background
        if (categoryItems[position].flag) {
            holder.name_tv.background = ContextCompat.getDrawable(ctx, R.drawable.custom_btn_on)
            holder.name_tv.setTextColor(Color.parseColor("#ffffff"))
        } else {
            holder.name_tv.background = ContextCompat.getDrawable(ctx, R.drawable.custom_btn_off)
            holder.name_tv.setTextColor(Color.parseColor("#3c3c3c"))
        }
    }
}
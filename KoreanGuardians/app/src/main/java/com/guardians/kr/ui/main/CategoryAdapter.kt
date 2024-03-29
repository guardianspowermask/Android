package com.guardians.kr.ui.main

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.guardians.kr.R
import com.guardians.kr.network.get.GetCategoryResponseData
import com.guardians.kr.ui.report.ReportActivity

class CategoryAdapter(val ctx : Context, var categoryItems: ArrayList<GetCategoryResponseData>) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(mainView)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Glide.with(ctx).load(categoryItems[position].img).into(holder.icon_iv)
        holder.name_tv.text = categoryItems[position].name
        holder.cnt_tv.text = "(${categoryItems[position].item_cnt})"
        var tmp = ""
        for (i in categoryItems[position].replace_words) {
            tmp += "#$i "
        }
        holder.hashtag_tv.text = tmp.trim()

        holder.wrap_const.setOnClickListener {
            Intent(ctx, ReportActivity::class.java).let {
                it.putExtra("CATEGORY", categoryItems)
                it.putExtra("IDX", categoryItems[position].category_idx)
                ctx.startActivity(it)
            }
        }
    }
}
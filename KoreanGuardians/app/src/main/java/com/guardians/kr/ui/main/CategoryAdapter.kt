package com.guardians.kr.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.guardians.kr.R

class CategoryAdapter(val ctx : Context, var categoryItems: ArrayList<CategoryItem>) : RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(mainView)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Glide.with(ctx).load(categoryItems[position].img).into(holder.icon_iv)
        holder.name_tv.text = categoryItems[position].name
        holder.cnt_tv.text = "(${categoryItems[position].cnt})"
        var tmp = ""
        categoryItems[position].replacement.onEach { tmp += "#$it " }
        holder.hashtag_tv.text = tmp.trim()
    }
}
package com.guardians.kr.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.guardians.kr.R
import android.widget.Toast
import android.net.Uri
import android.content.*
import android.util.Log
import com.guardians.kr.get.GetItemResponseDataItem
import com.guardians.kr.network.ApplicationController
import com.guardians.kr.network.NetworkService
import com.guardians.kr.ui.detail.DetailActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemAdapter(var ctx: Context, var itemItems: ArrayList<GetItemResponseDataItem>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ItemViewHolder(mainView)
    }

    override fun getItemCount(): Int = itemItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.name_tv.text = itemItems[position].name
        holder.store_tv.text = itemItems[position].store
        Glide.with(ctx).load(itemItems[position].img).into(holder.img_iv)
        holder.cnt_tv.text = itemItems[position].report_cnt.toString()

        holder.btn_iv.setOnClickListener {
            ctx.startActivity(Intent(ctx, DetailActivity::class.java))
        }
    }
}
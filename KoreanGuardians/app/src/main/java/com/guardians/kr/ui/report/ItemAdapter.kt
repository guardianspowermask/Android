package com.guardians.kr.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.guardians.kr.R
import com.guardians.kr.ui.report.ItemItem

class ItemAdapter(var ctx: Context, var itemItems: ArrayList<ItemItem>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ItemViewHolder(mainView)
    }

    override fun getItemCount(): Int = itemItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.name_tv.text = itemItems[position].name
        holder.store_tv.text = itemItems[position].store
        Glide.with(ctx).load(itemItems[position].img).into(holder.img_iv)
        holder.cnt_tv.text = itemItems[position].cnt.toString()

        holder.btn_iv.setOnClickListener {
            if (itemItems[position].email != null){
                // TODO go to email
            } else {
                // TODO go to facebook messenger
            }
        }
    }
}
package com.guardians.kr.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.guardians.kr.R
import android.content.*
import com.guardians.kr.network.get.GetItemResponseDataItem
import com.guardians.kr.ui.detail.DetailActivity

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

        if (itemItems[position].report_flag) {
            holder.btn_iv.setImageResource(R.drawable.custom_btn_white)
            holder.btn_tv.text = "항의완료"
        }

        holder.btn_iv.setOnClickListener {
            Intent(ctx, DetailActivity::class.java).let {
                it.putExtra("ITEM_IDX", itemItems[position].item_idx)
                it.putExtra("NAME", itemItems[position].name)
                it.putExtra("STORE", itemItems[position].store)
                it.putExtra("IMG", itemItems[position].img)
                it.putExtra("FEEDBACK_FLAG", itemItems[position].feedback_flag)
                ctx.startActivity(it)
            }
        }
    }
}
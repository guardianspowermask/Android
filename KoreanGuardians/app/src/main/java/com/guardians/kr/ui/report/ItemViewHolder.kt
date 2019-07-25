package com.guardians.kr.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.guardians.kr.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name_tv : TextView = itemView.findViewById(R.id.tv_name_item_item)
    var store_tv : TextView = itemView.findViewById(R.id.tv_store_item_item)
    var img_iv : ImageView = itemView.findViewById(R.id.iv_img_item_item)
    var cnt_tv : TextView = itemView.findViewById(R.id.tv_cnt_item_item)
    var btn_iv : ImageView = itemView.findViewById(R.id.iv_btn_item_item)
}
package com.guardians.kr.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.guardians.kr.R

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name_tv : TextView = itemView.findViewById(R.id.tv_name_item_category)
    var icon_iv : ImageView = itemView.findViewById(R.id.iv_icon_item_category)
    var cnt_tv : TextView = itemView.findViewById(R.id.tv_cnt_item_category)
    var hashtag_tv : TextView = itemView.findViewById(R.id.tv_hashtag_item_category)
}
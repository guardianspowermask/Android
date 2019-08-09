package com.guardians.kr.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.guardians.kr.R

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name_tv : TextView = itemView.findViewById(R.id.tv_name_item_comment)
    var date_tv : TextView = itemView.findViewById(R.id.tv_date_item_comment)
    var content_tv : TextView = itemView.findViewById(R.id.tv_comment_item_comment)
}
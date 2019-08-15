package com.guardians.kr.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guardians.kr.R
import com.guardians.kr.network.get.GetCommentResponseData

class CommentAdapter(var ctx: Context, var commentItems: ArrayList<GetCommentResponseData>) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(mainView)
    }

    override fun getItemCount(): Int = commentItems.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.name_tv.text = commentItems[position].name
        holder.date_tv.text = commentItems[position].date
        holder.content_tv.text = commentItems[position].comment
    }
}
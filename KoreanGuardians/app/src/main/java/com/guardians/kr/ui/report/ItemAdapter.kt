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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemAdapter(var ctx: Context, var itemItems: ArrayList<GetItemResponseDataItem>) : RecyclerView.Adapter<ItemViewHolder>() {
    private var networkService : NetworkService = ApplicationController.instance.networkService

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
            communicate(itemItems[position].item_idx)

            itemItems[position].report_cnt++

            if (itemItems[position].email != ""){
                sendEmail(itemItems[position].email?:"", itemItems[position].name)

            } else {
                sendMsg(itemItems[position].facebook?:"", itemItems[position].name)
            }

            notifyDataSetChanged()
        }
    }

    private fun sendEmail(email: String, name: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        intent.putExtra(Intent.EXTRA_SUBJECT, "[$name] 제품명에 대해서 건의합니다.")
        intent.putExtra(Intent.EXTRA_TEXT, "안녕하세요,\n\n귀사의 ($name) 제품명에 대해 건의할 사항이 있습니다.\n\n충분히 우리말로 만들 수 있는 제품명에 굳이 일본어를 사용할 필요가 없다고 생각합니다.\n\n고작 하나의 제품 이름일 뿐이라고 생각하지 말고 언어 사용의 중요성에 대해 인지하시길 바랍니다.\n\n감사합니다 :)")
        ctx.startActivity(Intent.createChooser(intent, "항의 메일 보내기"))
    }

    private fun sendMsg(userId: String, name: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.me/$userId"))

        copyText("안녕하세요,\n\n귀사의 ($name) 제품명에 대해 건의할 사항이 있습니다.\n\n충분히 우리말로 만들 수 있는 제품명에 굳이 일본어를 사용할 필요가 없다고 생각합니다.\n\n고작 하나의 제품 이름일 뿐이라고 생각하지 말고 언어 사용의 중요성에 대해 인지하시길 바랍니다.\n\n감사합니다 :)")

        Toast.makeText(ctx,"샘플 메세지가 복사되었습니다.\n붙여넣기를 해보세요. :)", Toast.LENGTH_SHORT).show()

        try {
            ctx.startActivity(intent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(ctx, "메신저를 열 수 없습니다. 나중에 다시 시도해보세요!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun copyText(msg: String) {
        val clipboard = ctx.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("fb", msg)
        clipboard!!.primaryClip = clip
    }

    private fun communicate(idx: Int) {
        val putItem = networkService.putItemReport(idx)
        putItem.enqueue(object : Callback<Any>{
            override fun onFailure(call: Call<Any>?, t: Throwable?) {
                Log.d("Error::Item", "$t")
            }

            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
            }

        })
    }

}
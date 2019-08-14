package com.guardians.kr.network.get

data class GetItemResponse (
    var message : String,
    var data : GetItemResponseData
)

data class GetItemResponseData (
    var total_cnt : Int,
    var items : ArrayList<GetItemResponseDataItem>
)

data class GetItemResponseDataItem (
    var item_idx : Int,
    var name : String,
    var img : String,
    var report_cnt : Int,
    var feedback_flag : Int,
    var store : String
)
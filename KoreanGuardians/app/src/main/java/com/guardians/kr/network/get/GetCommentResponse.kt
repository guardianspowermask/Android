package com.guardians.kr.network.get

data class GetCommentResponse (
    var message : String,
    var data : ArrayList<GetCommentResponseData>
)

data class GetCommentResponseData (
    var user_comment_idx: Int,
    var name: String,
    var item_idx: Int,
    var user_idx: Int,
    var content: String,
    var date: String
)
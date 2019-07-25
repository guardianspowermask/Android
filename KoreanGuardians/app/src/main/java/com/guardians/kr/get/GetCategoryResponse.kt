package com.guardians.kr.get

data class GetCategoryResponse (
    var message : String,
    var data : ArrayList<GetCategoryResponseData>

)

data class GetCategoryResponseData (
    var category_idx : Int,
    var name : String,
    var item_cnt : Int,
    var img : String,
    var replace_words : ArrayList<String>
)
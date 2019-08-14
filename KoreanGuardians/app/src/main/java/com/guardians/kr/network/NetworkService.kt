package com.guardians.kr.network

import com.guardians.kr.get.GetCategoryResponse
import com.guardians.kr.get.GetFeedbackResponse
import com.guardians.kr.get.GetItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NetworkService {
    // 카테고리 보기
    @GET("category")
    fun getCategory() : Call<GetCategoryResponse>

    // 아이템 보기
    @GET("item/{category_idx}/{order}")
    fun getItem(@Path("category_idx") category_idx : Int,
                @Path("order") order : Int) : Call<GetItemResponse>

    // 피드백 보기
    @GET("feedback/{item_idx}")
    fun getItemFeedback(@Path("item_idx") item_idx : Int) : Call<GetFeedbackResponse>

}
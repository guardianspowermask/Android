package com.guardians.kr.network

import com.guardians.kr.get.GetCategoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    // 카테고리 보기
    @GET("category")
    fun getCategory() : Call<GetCategoryResponse>

}
package com.guardians.kr.network

import com.guardians.kr.network.get.GetCategoryResponse
import com.guardians.kr.network.get.GetCommentResponse
import com.guardians.kr.network.get.GetFeedbackResponse
import com.guardians.kr.network.get.GetItemResponse
import com.guardians.kr.network.post.PostBlankResponse
import com.guardians.kr.network.post.PostCommentRequestDTO
import com.guardians.kr.network.post.PostLoginRequestDTO
import com.guardians.kr.network.post.PostStringResponseData
import retrofit2.Call
import retrofit2.http.*

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

    // 로그인
    @POST("login")
    fun postLogin(@Body body : PostLoginRequestDTO) : Call<PostStringResponseData>

    // 댓글 보기
    @GET("comment/{item_idx}")
    fun getComment(@Path("item_idx") item_idx : Int) : Call<GetCommentResponse>

    // 댓글 달기
    @POST("comment")
    fun postComment(@Header("Authorization") token : String,
                    @Body body : PostCommentRequestDTO) : Call<PostBlankResponse>

}
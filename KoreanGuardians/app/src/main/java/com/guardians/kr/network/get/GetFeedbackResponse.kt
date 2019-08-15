package com.guardians.kr.network.get


data class GetFeedbackResponse (
    var message : String,
    var data : ArrayList<GetFeedbackResponseData>
)

data class GetFeedbackResponseData (
    var img : String,
    var date : String
)
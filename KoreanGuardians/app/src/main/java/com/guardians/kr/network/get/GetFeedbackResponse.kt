package com.guardians.kr.network.get


data class GetFeedbackResponse (
    var message : String,
    var data : GetFeedbackResponseData
)

data class GetFeedbackResponseData (
    var img : String,
    var date : String
)
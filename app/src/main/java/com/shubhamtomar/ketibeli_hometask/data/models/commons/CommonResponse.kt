package com.shubhamtomar.ketibeli_hometask.data.models.commons


import com.google.gson.annotations.SerializedName

data class CommonResponse<T>(
    @SerializedName("data")
    val data: T?,
    @SerializedName("status")
    val status: Status?
) {

    data class Status(
        @SerializedName("httpCode")
        val httpCode: String?,
        @SerializedName("message")
        val message: String?,
        @SerializedName("success")
        val success: Boolean?
    )

}
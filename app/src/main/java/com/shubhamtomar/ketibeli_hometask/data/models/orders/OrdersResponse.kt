package com.shubhamtomar.ketibeli_hometask.data.models.orders

import com.google.gson.annotations.SerializedName

data class OrdersResponse(
    @SerializedName("ordersResponseDTO")
    val ordersResponseDTO: List<Order>?,
    @SerializedName("totalItems")
    val totalItems: Int?,
    @SerializedName("totalPages")
    val totalPages: Int?
)
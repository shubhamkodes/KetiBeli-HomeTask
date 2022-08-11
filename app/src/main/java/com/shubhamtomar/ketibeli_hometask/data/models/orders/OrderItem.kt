package com.shubhamtomar.ketibeli_hometask.data.models.orders

import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("discount")
    val discount: Int?,
    @SerializedName("isDailyDealItem")
    val isDailyDealItem: Boolean?,
    @SerializedName("isItemGroupItem")
    val isItemGroupItem: Boolean?,
    @SerializedName("itemCategory")
    val itemCategory: String?,
    @SerializedName("itemId")
    val itemId: Int?,
    @SerializedName("itemImgUrl")
    val itemImgUrl: String?,
    @SerializedName("itemName")
    val itemName: String?,
    @SerializedName("orderId")
    val orderId: Int?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalItemAmount")
    val totalItemAmount: Int?,
    @SerializedName("userId")
    val userId: Int?
)
package com.shubhamtomar.ketibeli_hometask.data.models.orders


import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("cartType")
    val cartType: Any?,
    @SerializedName("couponCode")
    val couponCode: Any?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("createdAtEpoch")
    val createdAtEpoch: Any?,
    @SerializedName("discountAmount")
    val discountAmount: Int?,
    @SerializedName("expectedDeliveryDate")
    val expectedDeliveryDate: Any?,
    @SerializedName("grandTotal")
    val grandTotal: Any?,
    @SerializedName("isDeliveryDelayed")
    val isDeliveryDelayed: Any?,
    @SerializedName("isReturned")
    val isReturned: Any?,
    @SerializedName("orderAddressDTO")
    val orderAddressDTO: Any?,
    @SerializedName("orderDetails")
    val orderDetails: Any?,
    @SerializedName("orderId")
    val orderId: Int?,
    @SerializedName("orderItems")
    val orderItems: List<OrderItem>?,
    @SerializedName("payerEmail")
    val payerEmail: String?,
    @SerializedName("payerPhone")
    val payerPhone: String?,
    @SerializedName("paymentId")
    val paymentId: Int?,
    @SerializedName("paymentMode")
    val paymentMode: Any?,
    @SerializedName("paymentStatus")
    val paymentStatus: String?,
    @SerializedName("paymentType")
    val paymentType: Any?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("rating")
    val rating: Int?,
    @SerializedName("reason")
    val reason: String?,
    @SerializedName("rewardType")
    val rewardType: Any?,
    @SerializedName("saleOrderId")
    val saleOrderId: Any?,
    @SerializedName("shippingCost")
    val shippingCost: Int?,
    @SerializedName("showCancelButton")
    val showCancelButton: Any?,
    @SerializedName("showChatButton")
    val showChatButton: Any?,
    @SerializedName("showPaymentButton")
    val showPaymentButton: Any?,
    @SerializedName("solidStarIcon")
    val solidStarIcon: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalAmount")
    val totalAmount: Int?,
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("userName")
    val userName: Any?,
    @SerializedName("variantName")
    val variantName: Any?
)
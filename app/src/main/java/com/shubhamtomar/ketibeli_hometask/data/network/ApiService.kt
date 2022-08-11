package com.shubhamtomar.ketibeli_hometask.data.network

import com.shubhamtomar.ketibeli_hometask.data.models.commons.CommonResponse
import com.shubhamtomar.ketibeli_hometask.data.models.orders.OrdersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/v1/logistics/order")
    suspend fun getOrders(
        @Query("userId") userId: Long,
        @Query("status") status: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<CommonResponse<OrdersResponse>>

}
package com.shubhamtomar.ketibeli_hometask.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shubhamtomar.ketibeli_hometask.data.models.orders.Order
import com.shubhamtomar.ketibeli_hometask.data.network.ApiClient
import com.shubhamtomar.ketibeli_hometask.data.repository.pagingDataSource.OrdersDataSource
import kotlinx.coroutines.flow.Flow

object KetiBeliRepo {

    private val api by lazy {
        ApiClient.ketiBeliApi
    }

    fun getOrders(orderStatus: String, userId: Long): Flow<PagingData<Order>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                OrdersDataSource(
                    orderStatus = orderStatus,
                    userId = userId,
                    apiService = api
                )
            }, initialKey = 0
        ).flow
    }


}
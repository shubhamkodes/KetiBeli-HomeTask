package com.shubhamtomar.ketibeli_hometask.data.repository.pagingDataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shubhamtomar.ketibeli_hometask.data.models.orders.Order
import com.shubhamtomar.ketibeli_hometask.data.network.ApiService


class OrdersDataSource(
    private val orderStatus: String,
    private val userId: Long,
    private val apiService: ApiService
) :
    PagingSource<Int, Order>() {

    companion object {
        private const val PAGE_SIZE = 20
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Order> {
        try {
            val currentLoadingPageKey = params.key ?: 0

            val response = apiService.getOrders(
                status = orderStatus,
                userId = userId,
                page = currentLoadingPageKey,
                size = PAGE_SIZE
            )

            response.body()?.data?.let {

                val prevKey =
                    if (currentLoadingPageKey == 0) null
                    else currentLoadingPageKey.minus(1)

                val nextKey =
                    if ((it.totalPages ?: 0) > currentLoadingPageKey)
                        currentLoadingPageKey.plus(1)
                    else null

                return LoadResult.Page(
                    data = it.ordersResponseDTO ?: emptyList(),
                    prevKey = prevKey,
                    nextKey = nextKey
                )

            } ?: return LoadResult.Error(Throwable("Something went wrong"))


        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Order>): Int? {
        return null
    }

}
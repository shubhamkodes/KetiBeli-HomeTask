package com.shubhamtomar.ketibeli_hometask.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shubhamtomar.ketibeli_hometask.data.models.orders.Order
import com.shubhamtomar.ketibeli_hometask.data.repository.KetiBeliRepo
import kotlinx.coroutines.flow.Flow

class OrdersViewModel : ViewModel() {

    fun getOrders(orderStatus: String): Flow<PagingData<Order>> =
        KetiBeliRepo.getOrders(orderStatus, 107587).cachedIn(viewModelScope)

}
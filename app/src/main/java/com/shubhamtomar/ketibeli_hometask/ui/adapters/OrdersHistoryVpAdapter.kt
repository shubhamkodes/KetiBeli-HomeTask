package com.shubhamtomar.ketibeli_hometask.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shubhamtomar.ketibeli_hometask.ui.screens.orders.OrdersFragment
import com.shubhamtomar.ketibeli_hometask.utils.constants.AppConstants

class OrdersHistoryVpAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    private val titles = listOf(
        AppConstants.OrderStatus.CONFIRMED,
        AppConstants.OrderStatus.DISPATCHED,
        AppConstants.OrderStatus.COMPLETED,
        AppConstants.OrderStatus.CANCELLED
    )

    override fun getItemCount(): Int = titles.size

    override fun createFragment(position: Int): Fragment {
        return OrdersFragment.newInstance(getTitle(position) ?: "")
    }

    fun getTitle(position: Int): String? = if (position < titles.size) titles[position] else null

}
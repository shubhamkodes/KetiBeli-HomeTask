package com.shubhamtomar.ketibeli_hometask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shubhamtomar.ketibeli_hometask.R
import com.shubhamtomar.ketibeli_hometask.data.models.orders.Order
import com.shubhamtomar.ketibeli_hometask.data.models.orders.OrderItem
import com.shubhamtomar.ketibeli_hometask.databinding.ItemOrderBinding
import com.shubhamtomar.ketibeli_hometask.utils.constants.AppConstants.OrderStatus
import com.shubhamtomar.ketibeli_hometask.utils.extensions.click
import com.shubhamtomar.ketibeli_hometask.utils.extensions.visible
import com.shubhamtomar.ketibeli_hometask.utils.helpers.Utils

class OrdersAdapter(
    private val onClick: (Order?) -> Unit,
    private val onProductClick: (OrderItem) -> Unit = {}
) : PagingDataAdapter<Order, OrdersAdapter.OrderViewHolder>(OrderDiffUtil) {

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)
        val itemsAdapter = OrderProductsAdapter(onProductClick)

        holder.binding.apply {

            tvDate.text = Utils.getDayAndDate(order?.createdAt)
            tvOrderId.text = root.context.getString(R.string.order_no).plus(" ${order?.orderId}")

            rvOrderItems.adapter = itemsAdapter
            rvOrderItems.layoutManager = LinearLayoutManager(root.context)
            itemsAdapter.submitList(order?.orderItems)

            root click {
                onClick(order)
            }

            when (order?.status) {
                OrderStatus.CONFIRMED -> {

                }

                OrderStatus.DISPATCHED -> {

                }

                OrderStatus.COMPLETED -> {

                }

                OrderStatus.CANCELLED -> {
                    tvOrderCancelled.visible()
                }
            }
        }

    }

    inner class OrderViewHolder(val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root)

    object OrderDiffUtil : DiffUtil.ItemCallback<Order>() {
        override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean =
            oldItem.orderId == newItem.orderId

        override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        OrderViewHolder(
            ItemOrderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}
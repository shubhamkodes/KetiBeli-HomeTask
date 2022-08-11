package com.shubhamtomar.ketibeli_hometask.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.shubhamtomar.ketibeli_hometask.R
import com.shubhamtomar.ketibeli_hometask.data.models.orders.OrderItem
import com.shubhamtomar.ketibeli_hometask.databinding.ItemOrderProductBinding
import com.shubhamtomar.ketibeli_hometask.utils.constants.AppConstants.OrderItemStatus
import com.shubhamtomar.ketibeli_hometask.utils.extensions.*
import com.shubhamtomar.ketibeli_hometask.utils.helpers.PriceUtils

class OrderProductsAdapter(
    private val onClick: (OrderItem) -> Unit = {}
) :
    ListAdapter<OrderItem, OrderProductsAdapter.OrderProductViewHolder>(ProductDiffUtil) {
    override fun onBindViewHolder(holder: OrderProductViewHolder, position: Int) {
        val product = getItem(position)

        holder.binding.apply {

            ivThumbnail.load(product.itemImgUrl)
            tvName.text = product.itemName
            tvQty.text = root.context.getString(R.string.quantity).plus(" : ${product.quantity}")
            tvPrice.text = PriceUtils.formatPrice(product.price)

            when (product.status) {

                OrderItemStatus.PACKED -> {
                    tvStatus.apply {
                        visible()
                        makeGreen()

                        text = root.context.getString(R.string.status_product_is_being_prepared)
                        background = ActivityCompat.getDrawable(
                            root.context,
                            R.drawable.bg_border_rounded_green
                        )
                    }
                }

                OrderItemStatus.DELIVERED -> {
                    tvStatus.apply {
                        visible()
                        makeGreen()

                        text = root.context.getString(R.string.status_product_sent)
                        background =
                            ActivityCompat.getDrawable(
                                root.context,
                                R.drawable.bg_border_rounded_green
                            )
                    }
                }

                OrderItemStatus.CANCELLED -> {
                    tvStatus.apply {
                        visible()
                        makeOrange()

                        text = root.context.getString(R.string.status_cancelled)
                        background = ActivityCompat.getDrawable(
                            root.context,
                            R.drawable.bg_border_rounded_orange
                        )
                    }
                }

                else -> tvStatus.gone()

            }


            root click {
                onClick.invoke(product)
            }
        }

    }

    inner class OrderProductViewHolder(val binding: ItemOrderProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    object ProductDiffUtil : DiffUtil.ItemCallback<OrderItem>() {
        override fun areItemsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean =
            oldItem.itemId == newItem.itemId

        override fun areContentsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean =
            oldItem == newItem

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderProductsAdapter.OrderProductViewHolder =
        OrderProductViewHolder(
            ItemOrderProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


}
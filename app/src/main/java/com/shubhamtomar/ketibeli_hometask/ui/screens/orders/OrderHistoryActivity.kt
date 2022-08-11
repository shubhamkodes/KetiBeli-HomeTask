package com.shubhamtomar.ketibeli_hometask.ui.screens.orders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.shubhamtomar.ketibeli_hometask.R
import com.shubhamtomar.ketibeli_hometask.databinding.ActivityOrdersHistoryBinding
import com.shubhamtomar.ketibeli_hometask.ui.adapters.OrdersHistoryVpAdapter
import com.shubhamtomar.ketibeli_hometask.utils.constants.AppConstants

class OrderHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrdersHistoryBinding
    private val ordersVpAdapter by lazy {
        OrdersHistoryVpAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        onClick()
        setAdapter()
    }

    private fun onClick() {
        binding.apply {

            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }

        }
    }

    private fun initUI() {
        binding.toolbar.apply {
            title = getString(R.string.my_orders)
            setNavigationIcon(R.drawable.ic_arrow_back)
        }
    }

    private fun setAdapter() {
        binding.apply {

            vpOrders.adapter = ordersVpAdapter
            TabLayoutMediator(
                tabsOrders, vpOrders
            ) { tab, position ->
                val title = ordersVpAdapter.getTitle(position)

                tab.text = when (title) {
                    AppConstants.OrderStatus.CONFIRMED -> getString(R.string.order_confirmed)
                    AppConstants.OrderStatus.DISPATCHED -> getString(R.string.order_dispatched)
                    AppConstants.OrderStatus.COMPLETED -> getString(R.string.order_completed)
                    AppConstants.OrderStatus.CANCELLED -> getString(R.string.order_cancelled)
                    else -> ""
                }
            }.attach()

        }
    }


}
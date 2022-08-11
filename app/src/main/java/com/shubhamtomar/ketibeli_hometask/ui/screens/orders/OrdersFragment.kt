package com.shubhamtomar.ketibeli_hometask.ui.screens.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.shubhamtomar.ketibeli_hometask.databinding.FragmentOrdersBinding
import com.shubhamtomar.ketibeli_hometask.ui.adapters.OrdersAdapter
import com.shubhamtomar.ketibeli_hometask.ui.adapters.commons.FooterAdapter
import com.shubhamtomar.ketibeli_hometask.ui.viewmodels.OrdersViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class OrdersFragment : Fragment() {

    private lateinit var viewModel: OrdersViewModel
    private lateinit var binding: FragmentOrdersBinding

    private val ordersAdapter by lazy {
        OrdersAdapter(onClick = {
            // Handle Clicked order

        }, onProductClick = {
            // Handle Specific Product clicked

        })
    }

    private var orderStatus: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orderStatus = arguments?.getString(ORDER_STATUS)
        viewModel = ViewModelProvider(this)[orderStatus ?: "", OrdersViewModel::class.java]

        if (!orderStatus.isNullOrEmpty()) {
            getOrders(orderStatus!!)
        }

    }

    private fun getOrders(orderStatus: String) {
        lifecycleScope.launchWhenResumed {
            viewModel.getOrders(orderStatus).collectLatest {
                ordersAdapter.submitData(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        binding.rvOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())

            val orderAdapterWithLoading = ordersAdapter.withLoadStateFooter(
                footer = FooterAdapter { ordersAdapter.retry() }.apply {
                    loadState = LoadState.Loading
                }
            )

            adapter = orderAdapterWithLoading
        }

    }

    companion object {
        private const val ORDER_STATUS = "orderStatus"

        @JvmStatic
        fun newInstance(orderStatus: String?) =
            OrdersFragment().apply {
                arguments = Bundle().apply {
                    putString(ORDER_STATUS, orderStatus)
                }
            }
    }
}
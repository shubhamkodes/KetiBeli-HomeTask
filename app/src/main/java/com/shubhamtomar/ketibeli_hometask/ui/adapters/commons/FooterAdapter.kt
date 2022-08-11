package com.shubhamtomar.ketibeli_hometask.ui.adapters.commons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shubhamtomar.ketibeli_hometask.R
import com.shubhamtomar.ketibeli_hometask.databinding.ItemProgressBinding
import com.shubhamtomar.ketibeli_hometask.utils.extensions.click
import com.shubhamtomar.ketibeli_hometask.utils.extensions.isNetworkAvailable


class FooterAdapter(private val onRetry: () -> Unit) :
    LoadStateAdapter<FooterAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {

        holder.binding.apply {

            if (loadState is LoadState.Error)
                tvPlaceholderError.text =
                    if (root.context.isNetworkAvailable()) loadState.error.localizedMessage
                    else root.context.getString(R.string.internet_not_available)

            progressBar.isVisible = loadState is LoadState.Loading
            btRetry.isVisible = loadState is LoadState.Error
            tvPlaceholderError.isVisible = loadState is LoadState.Error

            btRetry click {
                onRetry.invoke()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ItemProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    class LoadStateViewHolder(val binding: ItemProgressBinding) :
        RecyclerView.ViewHolder(binding.root)

}
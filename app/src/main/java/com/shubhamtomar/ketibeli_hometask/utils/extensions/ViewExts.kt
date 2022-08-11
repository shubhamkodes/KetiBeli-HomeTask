package com.shubhamtomar.ketibeli_hometask.utils.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import com.shubhamtomar.ketibeli_hometask.R
import java.security.acl.Group


infix fun View.click(onClick: () -> Unit) {
    this.setOnClickListener { onClick() }
}


fun View.visible(): View {
    if (isVisible)
        return this

    this.visibility = View.VISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.inVisible(): View {
    this.visibility = View.INVISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.gone(): View {
    this.visibility = View.GONE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun TextView.makeGreen() {
    this.setTextColor(ResourcesCompat.getColor(resources, R.color.green, null))
}

fun TextView.makeOrange() {
    this.setTextColor(ResourcesCompat.getColor(resources, R.color.orange, null))
}

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        @Suppress("DEPRECATION")
        val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false

        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
    return false
}


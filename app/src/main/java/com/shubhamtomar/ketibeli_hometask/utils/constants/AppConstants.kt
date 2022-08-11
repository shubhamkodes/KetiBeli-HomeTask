package com.shubhamtomar.ketibeli_hometask.utils.constants

object AppConstants {

    object OrderStatus {
        const val DISPATCHED = "DISPATCHED"
        const val CONFIRMED = "CONFIRMED"
        const val COMPLETED = "COMPLETED"
        const val CANCELLED = "CANCELLED"
    }

    object OrderItemStatus {
        const val CANCELLED = "CANCELLED"
        const val PACKED = "PACKED"
        const val DELIVERED = "DELIVERED"
    }

    object HttpCode {
        const val SUCCESS = 200
    }
}
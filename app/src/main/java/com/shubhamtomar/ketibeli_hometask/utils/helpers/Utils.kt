package com.shubhamtomar.ketibeli_hometask.utils.helpers

import java.text.SimpleDateFormat

object Utils {

    fun getDayAndDate(timeStamp: String?): String? {
        if (timeStamp == null)
            return null

        return try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(timeStamp)
            SimpleDateFormat("EEE, MMM dd yyyy").format(date)
        } catch (e: Exception) {
            null
        }
    }

}
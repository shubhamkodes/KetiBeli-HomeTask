package com.shubhamtomar.ketibeli_hometask.utils.helpers

import java.math.RoundingMode
import java.text.DecimalFormat

object PriceUtils {

    fun formatPrice(amount: Any?): String =
        try {

            "Rp. " + DecimalFormat("##,###,##0.000")
                .apply {
                    roundingMode = RoundingMode.CEILING
                }.format(amount ?: 0)
        } catch (e: Exception) {
            "Rp. ".plus(amount ?: 0)
        }

}
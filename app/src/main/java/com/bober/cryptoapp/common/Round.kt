package com.bober.cryptoapp.common

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

fun Number?.roundTo2Decimals(): Double? {
    return this?.toDouble()?.let {
        BigDecimal(it).setScale(2, RoundingMode.HALF_UP).toDouble()
    }
}

fun Number?.smartRound(): Double? {
    return this?.toDouble()?.let { value ->
        if (value == 0.0) return 0.0

        if (kotlin.math.abs(value) >= 1) {
            // Regular rounding to 2 decimal places
            BigDecimal(value)
                .setScale(2, RoundingMode.HALF_UP)
                .toDouble()
        } else {
            // Significant digits for small numbers
            BigDecimal(value)
                .round(MathContext(3, RoundingMode.HALF_UP))
                .toDouble()
        }
    }
}
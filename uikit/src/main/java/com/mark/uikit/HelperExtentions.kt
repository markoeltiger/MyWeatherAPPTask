package com.mark.uikit

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toDayName(): String {
    // Convert seconds to milliseconds if needed
    val timeInMillis = if (this < 1_000_000_000_000L) this * 1000 else this

    val date = Date(timeInMillis)
    val format = SimpleDateFormat("EEEE", Locale.getDefault()) // "EEEE" gives full day name
    return format.format(date)
}
package com.joaovitor.coinappmb.ui.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


fun String.toBrazilianDateFormat(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault())
    inputFormat.timeZone = TimeZone.getTimeZone("UTC")

    val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    val date: Date? = inputFormat.parse(this)

    return if (date != null) outputFormat.format(date) else "Invalid date"
}
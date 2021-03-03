package dev.ebnbin.eb

import java.text.SimpleDateFormat
import java.util.Locale

fun timestamp(): Long {
    return System.currentTimeMillis()
}

fun Long.toTimeString(pattern: String = "yyyy-MM-dd HH:mm:ss:SSS"): String {
    return SimpleDateFormat(pattern, Locale.ROOT).format(this)
}

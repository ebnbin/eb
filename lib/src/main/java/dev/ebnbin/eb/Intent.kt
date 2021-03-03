package dev.ebnbin.eb

import android.content.Intent

fun Intent.hasExtraKey(key: String): Boolean {
    return extras?.hasKey(key) ?: false
}

inline fun <reified T : Any> Intent.getExtra(key: String): T? {
    return extras?.getValue(key)
}

inline fun <reified T : Any> Intent.requireExtra(key: String): T {
    return getExtra<T>(key).notNull()
}

inline fun <reified T : Any> Intent.getExtraOrDefault(key: String, defaultValue: T): T {
    return if (hasExtraKey(key)) requireExtra(key) else defaultValue
}

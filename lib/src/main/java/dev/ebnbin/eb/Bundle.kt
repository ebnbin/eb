package dev.ebnbin.eb

import android.os.Bundle

fun Bundle.hasKey(key: String): Boolean {
    return containsKey(key)
}

inline fun <reified T : Any> Bundle.getValue(key: String): T? {
    return get(key) as T?
}

inline fun <reified T : Any> Bundle.requireValue(key: String): T {
    return getValue<T>(key).notNull()
}

inline fun <reified T : Any> Bundle.getValueOrDefault(key: String, defaultValue: T): T {
    return if (hasKey(key)) requireValue(key) else defaultValue
}

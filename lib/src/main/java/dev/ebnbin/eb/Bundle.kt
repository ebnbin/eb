package dev.ebnbin.eb

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

//*********************************************************************************************************************

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

//*********************************************************************************************************************

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

//*********************************************************************************************************************

fun Activity.hasExtraKey(key: String): Boolean {
    return intent?.extras?.hasKey(key) ?: false
}

inline fun <reified T : Any> Activity.getExtra(key: String): T? {
    return intent?.extras?.getValue(key)
}

inline fun <reified T : Any> Activity.requireExtra(key: String): T {
    return getExtra<T>(key).notNull()
}

inline fun <reified T : Any> Activity.getExtraOrDefault(key: String, defaultValue: T): T {
    return if (hasExtraKey(key)) requireExtra(key) else defaultValue
}

//*********************************************************************************************************************

fun Fragment.hasArgKey(key: String): Boolean {
    return arguments?.hasKey(key) ?: false
}

inline fun <reified T : Any> Fragment.getArg(key: String): T? {
    return arguments?.getValue(key)
}

inline fun <reified T : Any> Fragment.requireArg(key: String): T {
    return getArg<T>(key).notNull()
}

inline fun <reified T : Any> Fragment.getArgOrDefault(key: String, defaultValue: T): T {
    return if (hasArgKey(key)) requireArg(key) else defaultValue
}

//*********************************************************************************************************************

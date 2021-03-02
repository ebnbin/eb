package dev.ebnbin.eb

import android.content.Context
import android.content.SharedPreferences

val defaultSharedPreferencesName: String
    get() = "${appId}_preferences"

fun getSharedPreferences(name: String = defaultSharedPreferencesName): SharedPreferences {
    return app.getSharedPreferences(name, Context.MODE_PRIVATE)
}

fun <T> SharedPreferences.get(key: String, defaultValue: T): T {
    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    return when (defaultValue) {
        is String -> getString(key, defaultValue)
        is Set<*> -> getStringSet(key, defaultValue as Set<String?>)
        is Int -> getInt(key, defaultValue)
        is Long -> getLong(key, defaultValue)
        is Float -> getFloat(key, defaultValue)
        is Boolean -> getBoolean(key, defaultValue)
        else -> e()
    } as T
}

fun <T> SharedPreferences.Editor.put(key: String, value: T): SharedPreferences.Editor {
    @Suppress("UNCHECKED_CAST")
    return when (value) {
        is String -> putString(key, value)
        is Set<*> -> putStringSet(key, value as Set<String?>)
        is Int -> putInt(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        is Boolean -> putBoolean(key, value)
        else -> e()
    }
}

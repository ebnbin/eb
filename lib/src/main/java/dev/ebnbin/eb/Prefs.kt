package dev.ebnbin.eb

abstract class Prefs {
    protected abstract val prefName: String

    protected fun <T : Any> createPref(key: String, defaultValue: T): Pref<T> {
        return object : Pref<T>() {
            override val key: String = key
            override val defaultValue: T = defaultValue
            override val name: String = prefName
        }
    }
}

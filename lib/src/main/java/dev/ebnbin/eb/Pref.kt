package dev.ebnbin.eb

import android.content.SharedPreferences
import androidx.lifecycle.LiveData

abstract class Pref<T : Any> : LiveData<T>(), SharedPreferences.OnSharedPreferenceChangeListener {
    abstract val key: String

    abstract val defaultValue: T

    abstract val name: String

    protected val sharedPreferences: SharedPreferences
        get() = getSharedPreferences(name)

    override fun onActive() {
        super.onActive()
        update()
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }

    override fun onInactive() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        super.onInactive()
    }

    override fun getValue(): T {
        return update()
    }

    public override fun setValue(value: T) {
        setValue(value, force = true)
    }

    fun setValue(value: T, force: Boolean) {
        apply(value)
        update(value, post = false, force = force)
    }

    public override fun postValue(value: T) {
        postValue(value, force = true)
    }

    fun postValue(value: T, force: Boolean) {
        apply(value)
        update(value, force = force)
    }

    fun commitValue(value: T, post: Boolean = true, force: Boolean = true): Boolean {
        return commit(value).also {
            update(post = post, force = force)
        }
    }

    private fun get(): T {
        return sharedPreferences.get(key, defaultValue)
    }

    private fun apply(value: T) {
        sharedPreferences.edit().put(key, value).apply()
    }

    private fun commit(value: T): Boolean {
        return sharedPreferences.edit().put(key, value).commit()
    }

    private fun update(value: T = get(), post: Boolean = true, force: Boolean = false): T {
        if (force || super.getValue() != value) {
            if (post) {
                super.postValue(value)
            } else {
                super.setValue(value)
            }
        }
        return value
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (this.sharedPreferences != sharedPreferences || this.key != key) return
        update()
    }

    companion object {
        fun <T : Any> create(key: String, defaultValue: T, name: String = defaultSharedPreferencesName): Pref<T> {
            return object : Pref<T>() {
                override val key: String = key
                override val defaultValue: T = defaultValue
                override val name: String = name
            }
        }
    }
}

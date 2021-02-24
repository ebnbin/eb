package dev.ebnbin.eb

import android.content.Context
import android.view.LayoutInflater
import androidx.core.content.getSystemService

private inline fun <reified T : Any> Context.requireSystemService(): T {
    return getSystemService<T>().notNull()
}

val Context.layoutInflater: LayoutInflater
    get() = requireSystemService()

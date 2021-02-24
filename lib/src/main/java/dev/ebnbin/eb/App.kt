package dev.ebnbin.eb

import android.app.Application

val app: Application
    get() = EBInitializer.app

inline fun <reified T : Application> app(): T {
    return app as T
}

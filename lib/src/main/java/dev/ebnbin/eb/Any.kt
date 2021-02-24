package dev.ebnbin.eb

inline fun <reified T : Any> T?.notNull(): T {
    return requireNotNull(this)
}

fun e(): Nothing {
    error("")
}

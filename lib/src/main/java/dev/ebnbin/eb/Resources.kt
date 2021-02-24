package dev.ebnbin.eb

import kotlin.math.roundToInt

val Float.dpToPx: Float
    get() = this * app.resources.displayMetrics.density

val Float.dpToPxRound: Int
    get() = dpToPx.roundToInt()

val Float.dpToPxInt: Int
    get() = dpToPx.toInt()

val Int.pxToDp: Float
    get() = this / app.resources.displayMetrics.density

val Float.spToPx: Float
    get() = this * app.resources.displayMetrics.scaledDensity

val Float.spToPxRound: Int
    get() = spToPx.roundToInt()

val Float.spToPxInt: Int
    get() = spToPx.toInt()

val Int.pxToSp: Float
    get() = this / app.resources.displayMetrics.scaledDensity

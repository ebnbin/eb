package dev.ebnbin.eb

import android.os.Build

const val sdk21L5 = Build.VERSION_CODES.LOLLIPOP
const val sdk22L51 = Build.VERSION_CODES.LOLLIPOP_MR1
const val sdk23M6 = Build.VERSION_CODES.M
const val sdk24N7 = Build.VERSION_CODES.N
const val sdk25N71 = Build.VERSION_CODES.N_MR1
const val sdk26O8 = Build.VERSION_CODES.O
const val sdk27O81 = Build.VERSION_CODES.O_MR1
const val sdk28P9 = Build.VERSION_CODES.P
const val sdk29Q10 = Build.VERSION_CODES.Q
const val sdk30R11 = Build.VERSION_CODES.R

fun sdk21L5() = Build.VERSION.SDK_INT >= sdk21L5

fun sdk22L51() = Build.VERSION.SDK_INT >= sdk22L51

fun sdk23M6() = Build.VERSION.SDK_INT >= sdk23M6

fun sdk24N7() = Build.VERSION.SDK_INT >= sdk24N7

fun sdk25N71() = Build.VERSION.SDK_INT >= sdk25N71

fun sdk26O8() = Build.VERSION.SDK_INT >= sdk26O8

fun sdk27O81() = Build.VERSION.SDK_INT >= sdk27O81

fun sdk28P9() = Build.VERSION.SDK_INT >= sdk28P9

fun sdk29Q10() = Build.VERSION.SDK_INT >= sdk29Q10

fun sdk30R11() = Build.VERSION.SDK_INT >= sdk30R11

package dev.ebnbin.eb

import android.app.Application
import android.graphics.drawable.Drawable
import android.os.Build

val app: Application
    get() = EBInitializer.app

inline fun <reified T : Application> app(): T {
    return app as T
}

val appId: String
    get() = app.packageName

val appVersionCode: Int
    get() {
        val packageInfo = app.packageManager.getPackageInfo(appId, 0)
        return if (Build.VERSION.SDK_INT >= SDK_28_P_9) {
            packageInfo.longVersionCode.toInt()
        } else {
            @Suppress("DEPRECATION")
            packageInfo.versionCode
        }
    }

val appVersionName: String
    get() = app.packageManager.getPackageInfo(appId, 0).versionName

val appLabel: CharSequence
    get() = app.packageManager.getApplicationLabel(app.applicationInfo)

val appIcon: Drawable
    get() = app.packageManager.getApplicationIcon(app.applicationInfo)

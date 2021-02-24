package dev.ebnbin.eb

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.core.content.ContentProviderCompat

internal class EBInitializer : ContentProvider() {
    override fun onCreate(): Boolean {
        initApp()
        return true
    }

    private fun initApp() {
        app = ContentProviderCompat.requireContext(this).applicationContext as Application
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?,
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        return 0
    }

    companion object {
        internal lateinit var app: Application
            private set
    }
}

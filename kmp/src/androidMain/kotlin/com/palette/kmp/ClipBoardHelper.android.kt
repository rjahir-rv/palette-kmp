package com.palette.kmp

import android.content.Context
import android.content.ClipboardManager
import android.content.ClipData
import android.os.Build
import androidx.annotation.RequiresApi

private var appContext: Context? = null

fun setAndroidContext(context: Context) {
    appContext = context.applicationContext
}

@RequiresApi(Build.VERSION_CODES.HONEYCOMB)
actual fun copyToClipboard(text: String) {
    appContext?.let { context ->
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("palette", text)
        clipboard.setPrimaryClip(clip)
    }
}
package com.palette.app

import android.app.Application
import com.palette.kmp.di.androidDatabaseModule
import com.palette.kmp.di.sharedModule
import com.palette.kmp.initKoinAndroid

class PaletteApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinAndroid(this@PaletteApp)
    }
}
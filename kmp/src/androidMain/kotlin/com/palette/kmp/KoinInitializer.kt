package com.palette.kmp

import android.content.Context
import com.palette.kmp.di.androidDatabaseModule
import com.palette.kmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

fun initKoinAndroid(context: Context) {
    startKoin {
        androidContext(context)
        modules(androidDatabaseModule, sharedModule)
    }
}
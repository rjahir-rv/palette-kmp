package com.palette.kmp.di

import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(iosDatabaseModule, sharedModule)
    }
}
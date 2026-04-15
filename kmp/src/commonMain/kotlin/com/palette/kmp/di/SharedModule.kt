package com.palette.kmp.di

import com.palette.kmp.room.CreateDatabase
import com.palette.kmp.room.PaletteDB
import org.koin.dsl.module


val sharedModule = module {
    single <PaletteDB> {
        CreateDatabase(get()).getDatabase()
    }
}
package com.palette.kmp.di

import androidx.room.RoomDatabase
import com.palette.kmp.room.PaletteDB
import com.palette.kmp.room.iosDatabaseBuilder
import org.koin.dsl.module

val iosDatabaseModule = module {
    single<RoomDatabase.Builder<PaletteDB>> { iosDatabaseBuilder() }
}
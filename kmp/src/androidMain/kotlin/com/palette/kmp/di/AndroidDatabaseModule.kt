package com.palette.kmp.di

import androidx.room.RoomDatabase
import com.palette.kmp.room.PaletteDB
import com.palette.kmp.room.androidDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val androidDatabaseModule = module {
    single <RoomDatabase.Builder<PaletteDB>> { androidDatabaseBuilder(androidContext()) }
}
package com.palette.kmp.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun androidDatabaseBuilder(context: Context) : RoomDatabase.Builder<PaletteDB>{
    val dbFile = context.applicationContext.getDatabasePath("palette.db")
    return Room.databaseBuilder(
        context,
        name = dbFile.absolutePath
    )
}
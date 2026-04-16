package com.palette.kmp.repositories

import com.palette.kmp.models.ColorModel
import com.palette.kmp.room.PaletteDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

class ColorRepository(private val database: PaletteDB) {
    private val dispatchers = Dispatchers.IO

    suspend fun insertColor(color: ColorModel) {
        database.colorDao().insertColor(color)
    }

    suspend fun updateColor(color: ColorModel) {
        database.colorDao().updateColor(color)
    }

    suspend fun deleteColor(color: ColorModel) {
        database.colorDao().deleteColor(color)
    }

    suspend fun deleteColorById(idPalette: Int) {
        database.colorDao().deleteColorById(idPalette)
    }

    fun getColorById(idPalette: Int): Flow<List<ColorModel>?> {
        return database.colorDao().getColorById(idPalette)
    }

}
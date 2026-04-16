package com.palette.kmp.repositories

import com.palette.kmp.models.PaletteModel
import com.palette.kmp.room.PaletteDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow

class PaletteRepository(private val database: PaletteDB) {
    private val dispatcher = Dispatchers.IO

    suspend fun insertPalette(paletteItem: PaletteModel){
        with(dispatcher) {
            database.paletteDao().insertPalette(paletteItem)
        }
    }

    suspend fun updatePalette(paletteItem: PaletteModel) {
        with(dispatcher) {
            database.paletteDao().updatePalette(paletteItem)
        }
    }

    suspend fun deletePalette(paletteItem: PaletteModel) {
        with(dispatcher) {
            database.paletteDao().deletePalette(paletteItem)
        }
    }

    fun getAllPalettes(): Flow<List<PaletteModel>> {
        return database.paletteDao().getAllPalettes()
    }
}
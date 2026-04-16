package com.palette.kmp.usesCases

import com.palette.kmp.models.PaletteModel
import com.palette.kmp.repositories.PaletteRepository

class InsertPalette(private val paletteRepository: PaletteRepository) {
    suspend operator fun invoke(paletteItem: PaletteModel) {
        paletteRepository.insertPalette(paletteItem)
    }
}
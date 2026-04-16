package com.palette.kmp.usesCases

import com.palette.kmp.models.PaletteModel
import com.palette.kmp.repositories.PaletteRepository

class UpdatePalette(private val paletteRepository: PaletteRepository) {
    suspend operator fun invoke(paletteItem: PaletteModel) {
        paletteRepository.updatePalette(paletteItem)
    }
}
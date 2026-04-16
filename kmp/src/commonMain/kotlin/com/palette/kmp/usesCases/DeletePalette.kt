package com.palette.kmp.usesCases

import com.palette.kmp.models.PaletteModel
import com.palette.kmp.repositories.PaletteRepository

class DeletePalette(private val repository: PaletteRepository) {
    suspend operator fun invoke(palette: PaletteModel) {
        repository.deletePalette(palette)
    }
}

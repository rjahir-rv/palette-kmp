package com.palette.kmp.usesCases

import com.palette.kmp.models.PaletteModel
import com.palette.kmp.repositories.PaletteRepository
import kotlinx.coroutines.flow.Flow

class GetPalette(private val paletteRepository: PaletteRepository) {
    operator fun invoke(): Flow<List<PaletteModel>?> {
        return paletteRepository.getAllPalettes()
    }
}
package com.palette.kmp.usesCases

import com.palette.kmp.models.ColorModel
import com.palette.kmp.repositories.ColorRepository
import kotlinx.coroutines.flow.Flow

class GetColor (private val repository: ColorRepository) {
    operator fun invoke(idPalette: Int) : Flow<List<ColorModel>?> {
        return repository.getColorById(idPalette)
    }
}

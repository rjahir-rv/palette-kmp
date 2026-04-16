package com.palette.kmp.usesCases

import com.palette.kmp.repositories.ColorRepository

class DeleteColorById(private val repository: ColorRepository) {
    suspend operator fun invoke(idPalette: Int) {
        repository.deleteColorById(idPalette)
    }
}

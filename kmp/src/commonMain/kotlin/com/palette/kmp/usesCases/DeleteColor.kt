package com.palette.kmp.usesCases

import com.palette.kmp.models.ColorModel
import com.palette.kmp.repositories.ColorRepository

class DeleteColor(private val repository: ColorRepository) {
    suspend operator fun invoke(color: ColorModel) {
        repository.deleteColor(color)
    }
}
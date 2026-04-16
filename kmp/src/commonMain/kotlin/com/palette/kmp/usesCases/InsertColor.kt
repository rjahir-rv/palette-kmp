package com.palette.kmp.usesCases

import com.palette.kmp.models.ColorModel
import com.palette.kmp.repositories.ColorRepository
import kotlin.collections.plus
import kotlin.random.Random

class InsertColor(private val repository: ColorRepository) {
    suspend operator fun invoke(idPalette: Int){
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        val hex = ColorModel.rgbToHex(r, g, b)
        val rgb = "rgb($r, $g, $b)"
        val color = ColorModel(0, idPalette, r, g, b, hex, rgb)
        repository.insertColor(color)
    }
}
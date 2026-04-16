package com.palette.kmp.usesCases

import com.palette.kmp.models.ColorModel
import com.palette.kmp.repositories.ColorRepository

class UpdateColor (private val repository: ColorRepository) {
    suspend operator fun invoke(color: ColorModel, r: Int, g: Int, b: Int) {
        val hex = ColorModel.rgbToHex(r, g, b)
        val rgb = "rgb($r, $g, $b)"
        val updateColor = color.copy(
            red = r,
            green = g,
            blue = b,
            hex = hex,
            rgb = rgb
        )
        repository.updateColor(updateColor)
    }
}
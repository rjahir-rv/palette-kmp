package com.palette.kmp.viewModels

import androidx.lifecycle.ViewModel
import com.palette.kmp.models.ColorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class ColorViewModel : ViewModel() {
    private val _colors = MutableStateFlow<List<ColorModel>>(emptyList())
    val colors: StateFlow<List<ColorModel>> = _colors //VIEWS

    private var id = 1

    fun generateColor(){
        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        val hex = ColorModel.rgbToHex(r, g, b)
        val rgb = "rgb($r, $g, $b)"

        val newColor = ColorModel(id++, r,g,b,hex,rgb )
        _colors.value += newColor

    }

    fun deleteColorById(id: Int){
        _colors.value = _colors.value.filter { it.id != id }
    }

    fun editColorById(id: Int, r: Int, g: Int, b: Int) {
        val hex = ColorModel.rgbToHex(r, g, b)
        val rgb = "rgb($r, $g, $b)"
        _colors.value = _colors.value.map {
            if (it.id == id) {
                it.copy(red = r, green = g, blue = b, hex = hex, rgb = rgb)
            } else {
                it
            }
        }
    }

    fun copyAll() {
        val allHexColors = _colors.value.joinToString("\n") { it.hex }
        com.palette.kmp.copyToClipboard(allHexColors)
    }

    fun refresh() {
        _colors.value = emptyList()
        id = 1
    }

}
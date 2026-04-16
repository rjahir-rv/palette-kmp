package com.palette.kmp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palette.kmp.copyToClipboard
import com.palette.kmp.models.ColorModel
import com.palette.kmp.usesCases.DeleteColor
import com.palette.kmp.usesCases.DeleteColorById
import com.palette.kmp.usesCases.GetColor
import com.palette.kmp.usesCases.InsertColor
import com.palette.kmp.usesCases.UpdateColor
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ColorViewModel(
    private val getColor: GetColor,
    private val insertColor: InsertColor,
    private val updateColor: UpdateColor,
    private val deleteColor: DeleteColor,
    private val deleteColorById: DeleteColorById
) : ViewModel() {

    private val _idPalette = MutableStateFlow<Int?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val colors: StateFlow<List<ColorModel>?> = _idPalette
        .filterNotNull()
        .flatMapLatest { id ->
            getColor(id)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun setIdPalette(id: Int) {
        _idPalette.value = id
    }

    fun generateColor() {
        val id = _idPalette.value ?: return
        viewModelScope.launch {
            insertColor(id)
        }
    }

    fun deleteColor(color: ColorModel) {
        viewModelScope.launch {
            deleteColor.invoke(color)
        }
    }

    fun updateColor(color: ColorModel, r: Int, g: Int, b: Int) {
        viewModelScope.launch {
            updateColor.invoke(color, r, g, b)
        }
    }

    fun deleteAllColors() {
        val id = _idPalette.value ?: return
        viewModelScope.launch {
            deleteColorById.invoke(id)
        }
    }

    fun copyAll() {
        val colorsList = colors.value ?: return
        val allHexColors = colorsList.joinToString("\n") { it.hex }
        copyToClipboard(allHexColors)
    }

}

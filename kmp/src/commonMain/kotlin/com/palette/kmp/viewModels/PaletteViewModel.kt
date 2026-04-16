package com.palette.kmp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palette.kmp.models.PaletteModel
import com.palette.kmp.usesCases.GetPalette
import com.palette.kmp.usesCases.InsertPalette
import com.palette.kmp.usesCases.UpdatePalette
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PaletteViewModel(
    private val insertPalette: InsertPalette,
    private val updatePalette: UpdatePalette,
    private val getPalette: GetPalette
) : ViewModel() {

    val palettes: StateFlow<List<PaletteModel>?> = getPalette.invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun insertPalette(paletteItem: PaletteModel) {
        viewModelScope.launch {
            insertPalette.invoke(paletteItem)
        }
    }

    fun updatePalette(paletteItem: PaletteModel) {
        viewModelScope.launch {
            updatePalette.invoke(paletteItem)
        }
    }
}
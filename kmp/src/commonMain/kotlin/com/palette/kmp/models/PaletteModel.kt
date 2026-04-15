package com.palette.kmp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "palettes")
data class PaletteModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val desc: String
)

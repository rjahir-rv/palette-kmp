package com.palette.kmp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "colors")
data class ColorModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idPalette: Int,
    val red: Int,
    val green: Int,
    val blue: Int,
    val hex: String,
    val rgb : String
){
    companion object{
        fun rgbToHex(r: Int, g: Int, b: Int): String {
            val red = r.toString(16).padStart(2, '0')
            val green = g.toString(16).padStart(2, '0')
            val blue = b.toString(16).padStart(2, '0')
            return "#$red$green$blue".uppercase()
        }
    }
}

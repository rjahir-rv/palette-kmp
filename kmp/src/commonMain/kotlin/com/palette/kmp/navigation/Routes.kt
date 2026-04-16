package com.palette.kmp.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Palette(val id: Int, val name: String, val desc: String)

@Serializable
data class ColorPreview(val id: Int, val name: String)

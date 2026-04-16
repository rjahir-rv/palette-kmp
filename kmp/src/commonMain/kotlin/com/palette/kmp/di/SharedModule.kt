package com.palette.kmp.di

import com.palette.kmp.repositories.ColorRepository
import com.palette.kmp.repositories.PaletteRepository
import com.palette.kmp.room.CreateDatabase
import com.palette.kmp.room.PaletteDB
import com.palette.kmp.usesCases.DeleteColor
import com.palette.kmp.usesCases.DeleteColorById
import com.palette.kmp.usesCases.DeletePalette
import com.palette.kmp.usesCases.GetColor
import com.palette.kmp.usesCases.GetPalette
import com.palette.kmp.usesCases.InsertColor
import com.palette.kmp.usesCases.InsertPalette
import com.palette.kmp.usesCases.UpdateColor
import com.palette.kmp.usesCases.UpdatePalette
import com.palette.kmp.viewModels.ColorViewModel
import com.palette.kmp.viewModels.PaletteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val sharedModule = module {
    single <PaletteDB> {
        CreateDatabase(get()).getDatabase()
    }

    singleOf(::PaletteRepository)
    singleOf(::ColorRepository)

    singleOf(::InsertPalette)
    singleOf(::UpdatePalette)
    singleOf(::GetPalette)
    singleOf(::DeletePalette)

    viewModelOf(::PaletteViewModel)
    viewModelOf(::ColorViewModel)


    singleOf(::InsertColor)
    singleOf(::UpdateColor)
    singleOf(::GetColor)
    singleOf(::DeleteColor)
    singleOf(::DeleteColorById)

}
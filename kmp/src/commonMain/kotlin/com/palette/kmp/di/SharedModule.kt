package com.palette.kmp.di

import com.palette.kmp.repositories.PaletteRepository
import com.palette.kmp.room.CreateDatabase
import com.palette.kmp.room.PaletteDB
import com.palette.kmp.usesCases.GetPalette
import com.palette.kmp.usesCases.InsertPalette
import com.palette.kmp.usesCases.UpdatePalette
import com.palette.kmp.viewModels.PaletteViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val sharedModule = module {
    single <PaletteDB> {
        CreateDatabase(get()).getDatabase()
    }

    singleOf(::PaletteRepository)

    singleOf(::InsertPalette)
    singleOf(::UpdatePalette)
    singleOf(::GetPalette)

    viewModelOf(::PaletteViewModel)

}
@file:Suppress("AssignedValueIsNeverRead")

package com.palette.kmp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.palette.kmp.components.ModalPalette
import com.palette.kmp.models.PaletteModel
import com.palette.kmp.navigation.Palette
import com.palette.kmp.viewModels.PaletteViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import palette.kmp.generated.resources.Res
import palette.kmp.generated.resources.ic_add
import palette.kmp.generated.resources.ic_arrow_forward
import palette.kmp.generated.resources.ic_more
import palette.kmp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = koinViewModel<PaletteViewModel>()
    var showModal by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row {
                        Image(
                            painter = painterResource(resource = Res.drawable.palette),
                            contentDescription = "Logo",
                            modifier = Modifier.height(24.dp)

                        )
                    }
                },
                actions = {
                    IconButton(onClick = {showModal = true} ){
                        Icon(
                            painter = painterResource(resource = Res.drawable.ic_add),
                            contentDescription = "Icon add"
                        )
                    }
                }
            )
        },
    ) { paddingValues ->
        ContentHome(modifier = Modifier.padding(paddingValues), navController = navController)
        if (showModal) {
            ModalPalette(
                palette = null,
                onDismiss = { showModal = false },
                onSave = {
                    viewModel.insertPalette(it)
                    showModal = false
                }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHome(modifier: Modifier, navController: NavController) {
    val viewModel = koinViewModel<PaletteViewModel>()
    val palettes by viewModel.palettes.collectAsState()
    var expanded by remember { mutableStateOf<Int?>(null) }
    var showModal by remember { mutableStateOf(false) }
    var selectedPalette by remember { mutableStateOf<PaletteModel?>(null) }


    LazyColumn(modifier) {
        items(palettes.orEmpty()) { item ->
            HorizontalDivider()
            ListItem(
                headlineContent = { Text(item.name) },
                supportingContent = { Text(item.desc, color = Color.LightGray) },
                leadingContent = {
                    Box {
                        IconButton(onClick = {expanded = item.id}) {
                            Icon(
                                painter = painterResource(Res.drawable.ic_more),
                                contentDescription = "Icon more"
                            )
                        }
                        DropdownMenu(
                            expanded = expanded == item.id,
                            onDismissRequest = { expanded = null }
                        ) {
                            DropdownMenuItem(
                                text = { Text(text = "Edit") },
                                onClick = { selectedPalette = item
                                    showModal = true
                                    expanded = null }
                            )

                            DropdownMenuItem(
                                text = { Text(text = "Delete") },
                                onClick = { expanded = null }
                            )
                        }
                    }

                },
                trailingContent = {
                    IconButton(onClick = {}){
                        Icon(painter = painterResource(Res.drawable.ic_arrow_forward), contentDescription = "Icon forward")
                    }
                },
                modifier = Modifier.clickable{
                    navController.navigate(Palette)
                }
            )
            HorizontalDivider()
        }
    }
    if (showModal) {
        ModalPalette(
            palette = selectedPalette,
            onDismiss = { showModal = false },
            onSave = {
                viewModel.updatePalette(it)
                showModal = false
            }
        )
    }

}

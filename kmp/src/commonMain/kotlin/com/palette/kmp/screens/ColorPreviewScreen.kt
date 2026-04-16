package com.palette.kmp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.palette.kmp.viewModels.ColorViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import palette.kmp.generated.resources.Res
import palette.kmp.generated.resources.ic_arrow_back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPreviewScreen(
    navController: NavController,
    id: Int,
    name: String,
    viewModel: ColorViewModel = koinViewModel()
) {
    LaunchedEffect(id) {
        viewModel.setIdPalette(id)
    }

    val colors by viewModel.colors.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = name) },
                navigationIcon = {
                    IconButton({ navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(resource = Res.drawable.ic_arrow_back),
                            contentDescription = "Icon back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            colors?.forEach { color ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color(color.red / 255f, color.green / 255f, color.blue / 255f))
                )
            }
        }
    }
}

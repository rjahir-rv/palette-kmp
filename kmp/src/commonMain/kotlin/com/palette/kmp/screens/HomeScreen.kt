package com.palette.kmp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.palette.kmp.components.ColorCard
import com.palette.kmp.components.MainSlider
import com.palette.kmp.copyToClipboard
import com.palette.kmp.viewModels.ColorViewModel
import org.jetbrains.compose.resources.painterResource
import palette.kmp.generated.resources.Res
import palette.kmp.generated.resources.ic_add
import palette.kmp.generated.resources.ic_copy_all
import palette.kmp.generated.resources.ic_refresh
import palette.kmp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: ColorViewModel = viewModel { ColorViewModel() }) {
    Surface(modifier = Modifier.fillMaxSize()) {
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
                        IconButton({ viewModel.copyAll() }) {
                            Icon(
                                painter = painterResource(resource = Res.drawable.ic_copy_all),
                                contentDescription = "Icon copy all"
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton({ viewModel.refresh() }) {
                            Icon(
                                painter = painterResource(resource = Res.drawable.ic_refresh),
                                contentDescription = "Icon refresh"
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    {viewModel.generateColor()},
                    modifier = Modifier.padding(16.dp),
                    shape = RoundedCornerShape(24.dp),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(
                        painter = painterResource(resource = Res.drawable.ic_add),
                        contentDescription = "Icon add"
                    )
                }
            }
        ) { paddingValues ->
            ContentHome(modifier = Modifier.padding(paddingValues))
        }
    }
}


@Suppress("AssignedValueIsNeverRead")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHome(modifier: Modifier, viewModel: ColorViewModel = viewModel { ColorViewModel() }) {
    val colors by viewModel.colors.collectAsState()
    val modalState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet by remember { mutableStateOf(false) }
    var red by remember { mutableStateOf(0f) }
    var green by remember { mutableStateOf(0f) }
    var blue by remember { mutableStateOf(0f) }
    var id by remember { mutableStateOf(0) }

    LazyColumn(modifier) {
        items(colors) { color ->
            ColorCard(
                color.hex,
                color.rgb,
                {
                    red = color.red.toFloat()
                    green = color.green.toFloat()
                    blue = color.blue.toFloat()
                    id = color.id
                    showBottomSheet = true},
                { copyToClipboard(color.hex) },
                {viewModel.deleteColorById(color.id)})

        }
    }
    if (showBottomSheet){
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = modalState,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Edit Color", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(80.dp)
                        .shadow(elevation = 12.dp)
                        .background(
                            color = Color(red / 255f, green / 255f, blue / 255f),
                            shape = RoundedCornerShape(12.dp)
                        )
                )

                Spacer(modifier = Modifier.height(16.dp))

                MainSlider(
                    value = red,
                    onValueChange = { red = it },
                    color = Color.Red

                )

                MainSlider(
                    value = green,
                    onValueChange = { green = it },
                    color = Color.Green

                )

                MainSlider(
                    value = blue,
                    onValueChange = { blue = it },
                    color = Color.Blue

                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedButton(
                    onClick = {
                        viewModel.editColorById(id, red.toInt(), green.toInt(), blue.toInt())
                        showBottomSheet = false
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Change color")
                }
            }
        }
    }
}

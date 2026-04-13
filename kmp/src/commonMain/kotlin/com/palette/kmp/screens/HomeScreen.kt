package com.palette.kmp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.palette.kmp.components.ColorCard
import org.jetbrains.compose.resources.painterResource
import palette.kmp.generated.resources.Res
import palette.kmp.generated.resources.ic_add
import palette.kmp.generated.resources.palette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
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
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    {},
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


@Composable
fun ContentHome(modifier: Modifier){
    Column(modifier) {
        ColorCard(
            hex = "#FF5733",
            rgb = "RGB(255, 87, 51)",
            onEdit = { /*TODO*/ },
            onCopy = { /*TODO*/ },
            onDelete = { /*TODO*/ }
        )
    }

}



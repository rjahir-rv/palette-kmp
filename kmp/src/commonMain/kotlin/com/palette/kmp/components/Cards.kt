package com.palette.kmp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import palette.kmp.generated.resources.Res
import palette.kmp.generated.resources.ic_copy
import palette.kmp.generated.resources.ic_delete
import palette.kmp.generated.resources.ic_edit

@Composable
fun ColorCard(
    hex: String,
    rgb: String,
    onEdit: () -> Unit,
    onCopy: () -> Unit,
    onDelete: () -> Unit
) {
    val color = Color(hex.removePrefix("#").toLong(16) or 0xFF000000)
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = hex, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(text = rgb, color = Color.White, fontWeight = FontWeight.Bold)
                }

            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                IconButton(onEdit){
                    Icon(painter = painterResource(resource = Res.drawable.ic_edit), contentDescription = "Icon edit")
                }

                IconButton(onCopy){
                    Icon(painter = painterResource(resource = Res.drawable.ic_copy), contentDescription = "Icon copy")
                }

                IconButton(onDelete){
                    Icon(painter = painterResource(resource = Res.drawable.ic_delete), contentDescription = "Icon delete")
                }
            }
        }

    }
}


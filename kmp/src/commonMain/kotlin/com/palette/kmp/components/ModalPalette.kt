package com.palette.kmp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.palette.kmp.models.PaletteModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalPalette(
    palette: PaletteModel? = null,
    onDismiss: () -> Unit = {},
    onSave:(PaletteModel) -> Unit
){
    val modalState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var name by remember { mutableStateOf(palette?.name ?: "") }
    var desc by remember { mutableStateOf(palette?.desc ?: "") }

    ModalBottomSheet(
        onDismiss,
        sheetState = modalState
    ){
        Column (modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(if (palette != null) "Edit Palette" else "Create Palette", fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Name")}
            )
            OutlinedTextField(
                value = desc,
                onValueChange = {desc = it},
                label = {Text("Description")}
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button({
                if (!name.isEmpty()) {
                    onSave(PaletteModel(id = palette?.id ?: 0, name = name, desc = desc))
                }
            }) {
                Text(if (palette != null) "Save" else "Create")
            }
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}
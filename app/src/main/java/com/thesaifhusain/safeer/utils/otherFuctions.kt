package com.thesaifhusain.safeer.utils

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookShelf(
    about: String,
    getFileName: String,
    getTopText: String,
    getImage: Int,
    fileName: MutableState<String>,
    enableLoadPdf: MutableState<Boolean>,
    updateTopText: MutableState<String>
) {
    Box(
        Modifier
            .padding(top = 70.dp)
            .fillMaxWidth()
            .clickable {
                fileName.value = getFileName
                enableLoadPdf.value = true
                updateTopText.value = getTopText
            }
    ) {
        // Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 105.dp)
        ) {
            OutlinedTextField(
                value = about,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
        // Image
        Box(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
                .padding(start = 12.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = getImage),
                    contentDescription = "",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(14.dp))
                )
                Text(
                    text = getTopText,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 20.dp, top = 65.dp),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}



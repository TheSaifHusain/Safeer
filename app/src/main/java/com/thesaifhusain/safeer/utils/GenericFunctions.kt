package com.thesaifhusain.safeer.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thesaifhusain.safeer.R

@Composable
fun genericButton(
    buttonText: String,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier.padding(bottom = 5.dp)
        .fillMaxWidth(0.7f)
) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Color(red = 206, green = 145, blue = 56))
    ) {
        Text(
            text = buttonText
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericEditText(text: String, label: String, onClick: (() -> Unit)?): String {
    val textData = remember { mutableStateOf(text) }
    OutlinedTextField(
        value = textData.value,
        onValueChange = { textData.value = it },
        label = { Text(text = label) },
        modifier = Modifier.padding(bottom = 5.dp)
            .clickable { onClick }
    )
    return textData.value
}

@Composable
fun genericTag(
    painter: Painter = painterResource(R.drawable.water_check_outline),
    text: String = "Service Name"
) {
    Card(
        modifier = Modifier.size(60.dp).padding(2.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painter,
                contentDescription = "a",
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun a() {
    genericTag()
}

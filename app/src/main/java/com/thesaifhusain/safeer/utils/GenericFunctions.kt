package com.thesaifhusain.safeer.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R
import java.util.*

@Composable
fun genericHeading(
    text: String = "Heading",
    modifier: Modifier = Modifier,
    textSize: TextUnit = 50.sp
) {
    Box(
        modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = textSize,
            color = MaterialTheme.colorScheme.onPrimary,
            // style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(start = 18.dp, top = 14.dp)
                .fillMaxWidth()

        )
    }
}

@Composable
fun genericButton(
    buttonText: String,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier
        .padding(bottom = 5.dp)
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
        modifier = Modifier
            .padding(bottom = 5.dp)
            .clickable { onClick }
    )
    return textData.value
}

@Composable
fun genericTag(
    painter: Painter = painterResource(R.drawable.water_check_outline),
    text: String = "Service Name",
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(60.dp)
            .padding(2.dp),
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun genericDatePicker(text: String = "Choose Date"): String {
    val myCalender = Calendar.getInstance()
    val year = myCalender.get(Calendar.YEAR)
    val month = myCalender.get(Calendar.MONTH)
    val day = myCalender.get(Calendar.DAY_OF_MONTH)

    val context = LocalContext.current
    val date = remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year1, month1, day1 ->
            val month = month1 + 1
            date.value = "$day1 - $month - $year1"
        },
        year,
        month,
        day
    )
    Image(
        imageVector = Icons.Default.CalendarMonth,
        contentDescription = "",
        modifier = Modifier.clickable { datePickerDialog.show() }
    )
    return date.value
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericConsoleCard(
    painter: Painter = painterResource(id = R.drawable.mosque),
    text: String = stringResource(id = R.string.addMasjid),
    textSize: TextUnit = 26.sp,
    modifer: Modifier = Modifier.size(172.dp).padding(5.dp)
) {
    Card(onClick = { /*TODO*/ }, modifier = modifer) {
        ConstraintLayout(
            Modifier.padding(12.dp)
                .fillMaxSize()
        ) {
            val (text_, image) = createRefs()
            Image(
                painter = painter,
                contentDescription = "",
                Modifier.size(50.dp)
                    .alpha(0.5f)
                    .constrainAs(image){
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .constrainAs(text_){
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun a() {
    genericConsoleCard()
}

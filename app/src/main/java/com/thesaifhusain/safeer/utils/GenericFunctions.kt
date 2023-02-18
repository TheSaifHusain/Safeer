package com.thesaifhusain.safeer.utils

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.twotone.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
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
fun genericEditText(
    text: String = "",
    label: String = "",
    inputType: KeyboardType = KeyboardType.Text,
    onClick: (() -> Unit)
): String {
    val textData = remember { mutableStateOf(text) }
    OutlinedTextField(
        value = textData.value,
        onValueChange = { textData.value = it },
        label = { Text(text = label) },
        modifier = Modifier
            .padding(bottom = 5.dp)
            .clickable { onClick }
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = inputType)
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
    text: String = "Add \nMasjid",
    textSize: TextUnit = 26.sp,
    modifier: Modifier = Modifier.size(172.dp).padding(5.dp),
    onClick: (() -> Unit)?,
    modifier2: Modifier = Modifier
) {
    Card(onClick = { /*TODO*/ }, modifier = modifier) {
        ConstraintLayout(
            modifier2.padding(12.dp)
                .fillMaxSize()
        ) {
            val (text_, image) = createRefs()
            Image(
                painter = painter,
                contentDescription = "",
                Modifier.size(50.dp)
                    .alpha(0.5f)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .constrainAs(text_) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericDropDown() {
    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(Modifier.padding(20.dp)) {
        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text("Label") },
            trailingIcon = {
                Icon(
                    icon,
                    "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded }
                )
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        mSelectedText = label
                        mExpanded = false
                    },
                    text = { Text(text = label ) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun genericDropDown() {
//    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
//
//    var selectedItem by remember {
//        mutableStateOf("")
//    }
//
//    var expanded by remember {
//        mutableStateOf(false)
//    }
//
//    ExposedDropdownMenuBox(
//        expanded = expanded,
//        onExpandedChange = {
//            expanded = !expanded
//        }
//    ) {
//        OutlinedTextField(
//            value = selectedItem,
//            onValueChange = { selectedItem = it },
//            label = { Text(text = "Select City") },
//            trailingIcon = {
//                ExposedDropdownMenuDefaults.TrailingIcon(
//                    expanded = expanded
//                )
//            },
//            colors = ExposedDropdownMenuDefaults.textFieldColors()
//            , modifier = Modifier.fillMaxWidth()
//        )
//
//        // filter options based on text field value
//        val filteringOptions =
//            listItems.filter { it.contains(selectedItem, ignoreCase = true) }
//
//        if (filteringOptions.isNotEmpty()) {
//            ExposedDropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false }
//            ) {
//                filteringOptions.forEach { selectionOption ->
//                    DropdownMenuItem(
//                        onClick = {
//                            selectedItem = selectionOption
//                            expanded = false
//                        },
//                        text = { Text(text = selectionOption) }
//                    )
//                }
//            }
//        }
//    }
// }

@Composable
fun genericContactPerson() {
    Card(Modifier.padding(12.dp)) {
        Text(text = "Contact Person", fontSize = 20.sp)
        genericEditText(
            text = "",
            label = "Enter Person Name",
            onClick = {}
        )
        genericEditText(
            text = "",
            label = "Enter Contact No.",
            onClick = {},
            inputType = KeyboardType.Number
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun genericInputChip(lable: String = "Defualt Text", icon: ImageVector = Icons.TwoTone.WaterDrop): Boolean {
    val selected = remember { mutableStateOf(false) }
    InputChip(
        selected = selected.value,
        onClick = { selected.value = !selected.value },
        label = { Text(text = lable) },
        leadingIcon = {
            Image(icon, contentDescription = null)
        },
        modifier = Modifier.padding(start = 5.dp, end = 5.dp)
    )
    return selected.value
}

@Preview(showSystemUi = true)
@Composable
private fun a() {
    genericContactPerson()
}
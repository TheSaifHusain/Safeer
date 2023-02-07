package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.genericConsoleCard
import com.thesaifhusain.safeer.utils.genericHeading

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ConsoleScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericHeading(text = stringResource(id = R.string.adminconsole)
        , textSize = 35.sp)
        Spacer(modifier = Modifier.size(50.dp))
        FlowRow(
            modifier = Modifier.verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            genericConsoleCard()
            genericConsoleCard(text = stringResource(id = R.string.addDargah))
            genericConsoleCard(text = stringResource(id = R.string.addImambargah))
            genericConsoleCard(text = stringResource(id = R.string.addMusafirkhana))
            genericConsoleCard(text = stringResource(id = R.string.addEvent))
            genericConsoleCard(text = stringResource(id = R.string.addFeedback))
        }
    }
}

// @Composable
// fun Selectimage(modifier: Modifier) {
//    Card(modifier = modifier) {
//        ConstraintLayout(Modifier.fillMaxSize()) {
//            val (image, Button) = createRefs()
//            Image(
//                Icons.Default.LocationOn,
//                contentDescription = "",
//                contetScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .constrainAs(image) {
//                        top.linkTo(parent.top)
//                        bottom.linkTo(parent.bottom)
//                        start.linkTo(parent.start)
//                        end.linkTo(parent.end)
//                    }
//            )
//            androidx.compose.material3.Button(
//                onClick = { /*TODO*/ },
//                modifier = Modifier.constrainAs(Button) {
//                    bottom.linkTo(parent.bottom, 5.dp)
//                    end.linkTo(parent.end, 5.dp)
//                }
//            ) {
//                Image(
//                    Icons.Default.Add,
//                    contentDescription = "",
//                    Modifier.padding(end = 5.dp),
//                    contentScale = ContentScale.FillBounds
//                )
//                Text(
//                    text = stringResource(id = R.string.picture),
//                    fontSize = 18.sp
//                )
//            }
//        }
//    }
// }

@Composable
fun SelectServices(modifier: Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = "Available Services : ",
            modifier = Modifier.padding(12.dp),
            fontSize = 18.sp
        )
        Row {
            ServiceCheckBox(text = "Wazu", isChecked = false, modifier = Modifier.weight(1f))
            ServiceCheckBox(text = "Jamat Namaz", isChecked = false, modifier = Modifier.weight(1f))
        }
        Row {
            ServiceCheckBox(text = "Namaz", isChecked = false, modifier = Modifier.weight(1f))
            ServiceCheckBox(text = "Munajat", isChecked = false, modifier = Modifier.weight(1f))
        }
        Row {
            ServiceCheckBox(text = "Drink Water", isChecked = false, modifier = Modifier.weight(1f))
            ServiceCheckBox(text = "Toilet", isChecked = false, modifier = Modifier.weight(1f))
        }
        Row {
            ServiceCheckBox(text = "AC", isChecked = false, modifier = Modifier.weight(1f))
            ServiceCheckBox(text = "Stay", isChecked = false, modifier = Modifier.weight(1f))
        }
        Row {
            ServiceCheckBox(
                text = "Historical Place",
                isChecked = false,
                modifier = Modifier.weight(1f)
            )
            ServiceCheckBox(
                text = "Family Place",
                isChecked = false,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ServiceCheckBox(text: String = "", isChecked: Boolean = false, modifier: Modifier = Modifier) {
    val isChecked0 = remember { mutableStateOf(isChecked) }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = isChecked0.value,
            onCheckedChange = { isChecked0.value = it },
            modifier = Modifier.weight(0.5f)
        )
        Text(text = text, modifier = Modifier.weight(1.2f))
    }
}

@Preview(name = "ConsoleScreen", showSystemUi = true)
@Composable
private fun PreviewConsoleScreen() {
    ConsoleScreen()
}

// @Composable
// fun ConsoleScreen() {
//    val mDate = remember { mutableStateOf(genericDatePicker().toString()) }
//    mDate.value = genericDatePicker()
//
//    ConstraintLayout(Modifier.verticalScroll(rememberScrollState()).fillMaxSize()) {
//        val (consoleText, image, editBox, services, button) = createRefs()
//        genericHeading(
//            text = stringResource(id = R.string.console),
//            textSize = 24.sp,
//            modifier = Modifier
//                .constrainAs(consoleText) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//        )
//        Selectimage(
//            modifier = Modifier
//                .height(180.dp)
//                .fillMaxWidth(0.9f)
//                .constrainAs(image) {
//                    top.linkTo(consoleText.bottom, 12.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        )
//        Box(
//            modifier = Modifier
//                .constrainAs(editBox) {
//                    top.linkTo(image.bottom, 5.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        ) {
//            Column {
//                genericEditText(
//                    text = "",
//                    label = stringResource(id = R.string.places),
//                    onClick = {}
//                )
//                genericEditText(text = "", label = stringResource(id = R.string.city), onClick = {})
//                genericEditText(
//                    text = "",
//                    label = stringResource(id = R.string.phone),
//                    onClick = {}
//                )
//                genericEditText(text = "", label = "Enter Contact Person name", onClick = {})
//                genericEditText(
//                    text = "",
//                    label = stringResource(id = R.string.email),
//                    onClick = {}
//                )
//                OutlinedTextField(
//                    value = mDate.value,
//                    onValueChange = { },
//                    readOnly = true,
//                    label = { Text(text = stringResource(id = R.string.ashraDate)) },
//                    trailingIcon = { genericDatePicker() }
//                )
//            }
//        }
//        SelectServices(
//            modifier = Modifier
//                .fillMaxWidth(0.9f)
//                .constrainAs(services) {
//                    top.linkTo(editBox.bottom, 12.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        )
//        genericButton(
//            buttonText = stringResource(id = R.string.submit),
//            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .fillMaxWidth(0.7f)
//                .constrainAs(button) {
//                    top.linkTo(services.bottom, 5.dp)
//                    // bottom.linkTo(parent.bottom, 5.dp)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    bottom.linkTo(parent.bottom, 14.dp)
//                }
//        )
//    }
// }

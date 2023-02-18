package com.thesaifhusain.safeer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.genericConsoleCard
import com.thesaifhusain.safeer.utils.genericHeading

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ConsoleScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericHeading(text = stringResource(id = R.string.adminconsole), textSize = 35.sp,)
        Spacer(modifier = Modifier.size(50.dp))
        FlowRow(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            genericConsoleCard(onClick = { } , modifier2 = Modifier.clickable { navController.navigate("masjid") })
            genericConsoleCard(text = stringResource(id = R.string.addDargah), onClick = {},)
            genericConsoleCard(text = stringResource(id = R.string.addImambargah), onClick = {})
            genericConsoleCard(text = stringResource(id = R.string.addMusafirkhana), onClick = {})
            genericConsoleCard(
                painterResource(id = R.drawable.history),
                text = stringResource(id = R.string.addEvent),
                onClick = {
                }
            )
            genericConsoleCard(
                painterResource(id = R.drawable.baseline_feedback_24),
                text = stringResource(id = R.string.addFeedback),
                onClick = {
                }
            )
        }
    }
}

@Preview(name = "ConsoleScreen", showSystemUi = true)
@Composable
private fun PreviewConsoleScreen() {
    ConsoleScreen(navController = rememberNavController())
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
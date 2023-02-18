package com.thesaifhusain.safeer.presentation.ConsoleScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R
import com.thesaifhusain.safeer.utils.*

@Composable
fun AddPlaces(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (header, middle0, middle1, middle2) = createRefs()
        genericHeading(
            text = "Add Default",
            Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Card(
            Modifier
                .padding(18.dp)
                .constrainAs(middle0) {
                    top.linkTo(header.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Selectimage()
            Spacer(modifier = Modifier.size(12.dp))
            commonDetail()
        }
//        personCard(
//            Modifier
//                .padding(14.dp)
//                .constrainAs(middle1) {
//                    top.linkTo(middle0.bottom)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        )
//        serviceCard(
//            modifier = Modifier
//                .padding(14.dp)
//                .constrainAs(middle2) {
//                    top.linkTo(middle1.bottom)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
//        )
    }
}

@Composable
fun Selectimage(modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            val (image, Button) = createRefs()
            Image(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.large)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            androidx.compose.material3.Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(Button) {
                    bottom.linkTo(parent.bottom, 5.dp)
                    end.linkTo(parent.end, 5.dp)
                }
            ) {
                Image(
                    Icons.Default.Add,
                    contentDescription = "",
                    Modifier.padding(end = 5.dp),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = stringResource(id = R.string.picture),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun commonDetail() {
    FlowColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericDropDown()
        genericEditText(label = stringResource(id = R.string.placeName), onClick = {})
        genericEditText(label = stringResource(id = R.string.address), onClick = {})
        genericEditText(label = stringResource(id = R.string.landmark), onClick = {})
        genericEditText(label = stringResource(id = R.string.pin), onClick = {})

    }
}

//@OptIn(ExperimentalLayoutApi::class)
//@Composable
//fun personCard(modifier: Modifier) {
//    FlowColumn(modifier = modifier.fillMaxSize()) {
//        Text(text = "Contact Person", fontSize = 35.sp)
//        Card(Modifier.padding(14.dp).fillMaxSize()) {
//            Column(
//                Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                genericEditText(label = " Enter Name", onClick = {})
//                Spacer(modifier = Modifier.size(5.dp))
//                genericEditText(label = " Enter Contact No.", onClick = {})
//            }
//        }
//    }
//}



@Preview(showSystemUi = true)
@Composable
private fun PreviewAddPlacs() {
    AddPlaces()
}
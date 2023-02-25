package com.thesaifhusain.safeer.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thesaifhusain.safeer.R

//@Composable
//fun genericImageSelect(modifier: Modifier = Modifier) {
//    Card(modifier = modifier) {
//        ConstraintLayout(
//            Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//        ) {
//            val (image, Button) = createRefs()
//            Image(
//                imageVector = Icons.Default.LocationOn,
//                contentDescription = "",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(MaterialTheme.shapes.large)
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
//}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun commonDetail() {
    FlowColumn(
        Modifier.fillMaxWidth()
            .padding(14.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        genericDropDown()
        genericEditText(onClick = {})
        genericEditText(onClick = {})
        genericEditText(onClick = {})
        genericEditText(onClick = {})
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun personCard(modifier: Modifier) {
    FlowColumn(modifier = modifier.fillMaxSize()) {
        Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Contact Person", fontSize = 35.sp,modifier=Modifier.weight(1f))
            Image(Icons.Default.AddCircle, contentDescription = null,modifier.weight(0.2f).size(40.dp))
        }
        Spacer(modifier = Modifier.size(12.dp))
        genericEditText(label = " Enter Name", onClick = {})
        Spacer(modifier = Modifier.size(5.dp))
        genericEditText(label = " Enter Contact No.", onClick = {},
        inputType = KeyboardType.Phone)
    }
}

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun day(text: String) : Boolean{
    val boolean = remember{ mutableStateOf(false) }
        InputChip(
            selected = boolean.value,
            onClick = { boolean.value = !boolean.value},
            label = { Text(text = text) })
    return boolean.value
}